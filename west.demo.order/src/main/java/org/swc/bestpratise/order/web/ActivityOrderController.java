package org.swc.bestpratise.order.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.swc.bestpratise.order.entity.Activity;
import org.swc.bestpratise.order.entity.ActivityOrder;
import org.swc.bestpratise.order.service.ActivityOrderService;
import org.swc.bestpratise.order.service.ActivityService;
/**
 * 活动订单
 * @author jake
 *
 */
@Controller
@RequestMapping(value = "/activity/order")
public class ActivityOrderController {
	
	@Autowired
	private ActivityOrderService activityOrderService;
	
	@Autowired
	private ActivityService activityService;
	
	@RequestMapping(value = "/save")
	public String save(RedirectAttributes redirectAttributes,ActivityOrder entity) {
		
		try {
			activityOrderService.saveEntity(entity);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return "redirect:list";
	}
	
	@RequestMapping(value = "/list")
	public String list(RedirectAttributes redirectAttributes,@RequestParam("id") Long id,Model model) {
		
		try {
			String[] keyName = new String[]{"activity_id"};
			String[] operate= new String[]{"="};
			Object[] keyValue= new Object[]{id};
			
			List<ActivityOrder> findEntityList = activityOrderService.findEntityList(keyName, operate, keyValue, 100, 1);
			model.addAttribute("allorder", findEntityList);
			
			Activity activity = activityService.findEntityById(id);
			model.addAttribute("activity", activity);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/activity/order-list";
	}
	
	@RequestMapping(value = "/list2")
	public String list2(RedirectAttributes redirectAttributes,@RequestParam("uuid") String uuid,Model model) {
		
		try {
			
			Activity activity = activityService.findEntityByUUID(uuid);
			
			String[] keyName = new String[]{"activity_id"};
			String[] operate= new String[]{"="};
			Object[] keyValue= new Object[]{activity.getId()};
			
			List<ActivityOrder> findEntityList = activityOrderService.findEntityList(keyName, operate, keyValue, 100, 1);
			model.addAttribute("allorder", findEntityList);
			
			
			model.addAttribute("activity", activity);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/activity/order-list2";
	}
	
} 
								