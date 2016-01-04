package org.swc.bestpratise.order.web;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.swc.bestpratise.order.entity.Activity;
import org.swc.bestpratise.order.service.ActivityService;

import com.bucuoa.west.orm.extend.Page;
/**
 * 活动
 * @author jake
 *
 */
@Controller
@RequestMapping(value = "/activity")
public class ActivityController {

	@Autowired
	private ActivityService activityService;
	
	@RequestMapping(value = "/add")
	public String add(RedirectAttributes redirectAttributes,Activity entity) {
		

		return "/activity/add";
	}
	
	@RequestMapping(value = "/save")
	public String save(RedirectAttributes redirectAttributes,Activity entity) {
		
		entity.setPlaceName("半亩园");
		entity.setTitle(new Date().toLocaleString()+"-"+entity.getPlaceName());
		entity.setCreater("");
		entity.setCreateTime(new Date());
		entity.setUuid(getUUID());
		try {
			Object idx = activityService.saveEntity(entity);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		long nanoTime = System.nanoTime();
		System.out.println(""+nanoTime);
		
//		System.out.println("--->"+count.get());
		return "redirect:list";
	}
	
//	private final AtomicLong count = new AtomicLong(0);
	
	@RequestMapping(value = "/save2")
	@ResponseBody
	public void save2(RedirectAttributes redirectAttributes,Activity entity) {
		
		entity.setPlaceName("半亩园");
		entity.setTitle(new Date().toLocaleString()+"-"+entity.getPlaceName());
		entity.setCreater("");
		entity.setCreateTime(new Date());
		entity.setUuid(getUUID());
		try {
			Object idx = activityService.saveEntity(entity);
			
//			System.out.println("id======>"+idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request,Model model,Page page) {
		
		long start = System.nanoTime();
		try {
			String[] keyName = new String[]{};
			String[] operate= new String[]{};
			Object[] keyValue= new Object[]{};
			
			String[] orderby= new String[]{"id"};
			String[] pattern= new String[]{"desc"};
			
//			List<Activity> findEntityList = activityService.findEntityList(keyName, operate, keyValue,orderby, pattern,page.getPageSize(), page.getPageNo());
//			model.addAttribute("allactivity", findEntityList);
			
			Page entityPage = activityService.getEntityPage(request);
			
			model.addAttribute("page", entityPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		long end = System.nanoTime();
		System.out.println("use :"+(end-start));
		return "/activity/list";
	}
	
	@RequestMapping(value = "/history")
	public String history(HttpServletRequest request,Model model,Page page) {
		
		try {
//			String[] keyName = new String[]{};
//			String[] operate= new String[]{};
//			Object[] keyValue= new Object[]{};
//			
//			String[] orderby= new String[]{"id"};
//			String[] pattern= new String[]{"desc"};
			
//			List<Activity> findEntityList = activityService.findEntityList(keyName, operate, keyValue,orderby, pattern,page.getPageSize(), page.getPageNo());
//			model.addAttribute("allactivity", findEntityList);
			
			Page entityPage = activityService.getEntityPage(request);
			
			model.addAttribute("page", entityPage);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/activity/history";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam("id") Long id) {
		
		try {
			
			boolean deleteEntityById = activityService.deleteEntityById(id);			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list";
	}

}