package org.swc.bestpratise.order.web;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.swc.bestpratise.order.entity.Activity;
import org.swc.bestpratise.order.entity.ActivityOrder;
import org.swc.bestpratise.order.entity.ActivityOrderDetail;
import org.swc.bestpratise.order.entity.Users;
import org.swc.bestpratise.order.service.ActivityOrderDetailService;
import org.swc.bestpratise.order.service.ActivityOrderService;
import org.swc.bestpratise.order.service.ActivityService;
/**
 * 活动订单明细
 * @author jake
 *
 */
@Controller
@RequestMapping(value = "/activity/orderdetail")
public class ActivityOrderDetailController {
	@Autowired
	private ActivityOrderDetailService activityOrderDetailService;
	
	@Autowired
	private ActivityService activityService;
	@Autowired
	private ActivityOrderService activityOrderService;
	
	
	@RequestMapping(value = "/add")
	public String add(RedirectAttributes redirectAttributes,Activity entity) {
		

		return "/activity/add-food";
	}
	
	@RequestMapping(value = "/addNon")
	public String addNon(RedirectAttributes redirectAttributes,Activity entity) {
		

		return "/activity/add-food2";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(RedirectAttributes redirectAttributes,@RequestParam("orderId") Long orderId) {
		
		try {
			activityOrderService.deleteEntityById(orderId);
			activityOrderDetailService.deleteEntityByOrderId(orderId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		redirectAttributes.addAttribute("id", orderId);
		return "redirect:/activity/order/list";
	}
	
	/**
	 * 注册用户保存
	 * @param request
	 * @param activityId
	 * @param userName
	 * @param red
	 * @return
	 */
	@RequestMapping(value = "/save")
	public String save(HttpServletRequest request,@RequestParam int activityId,@RequestParam String userName,RedirectAttributes red,HttpSession httpSession ) {
		int userId = 0;
		Users user = (Users)httpSession.getAttribute("user");
		
		String[] foods = request.getParameterValues("food");
		String[] nums = request.getParameterValues("num");
		
		int uid = user == null ? 0:user.getId();
		
		Object orderId = 0;
		if(foods!=null && foods.length > 0)
		{
			ActivityOrder order  = new ActivityOrder();
			order.setActivityId(activityId);
			order.setContent("");
			order.setCreateTime(new Date());
			order.setUserName(userName);
			
			order.setUserId(uid);
			try {
				orderId = activityOrderService.saveEntity(order);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			String content = "";
			int orderid = Integer.parseInt(orderId+"");
			for(int i = 0; i < foods.length; i ++)
			{
				String nn = nums[i];
				if(nn == null || nn.length()==0)
				{
					nn = "1";
				}
				ActivityOrderDetail entity = new ActivityOrderDetail();
				entity.setActivityId(activityId);
				entity.setProduct(foods[i]);;
				entity.setNums(Integer.parseInt(nn));
				entity.setPrice(0D);
//				entity.setUserId(userId);
				entity.setOrderId(orderid);
				entity.setUserName(userName);
				entity.setUserId(uid);
				
				try {
					if(foods[i] != null && !foods[i].equals(""))
					{
						activityOrderDetailService.saveEntity(entity);
						content += entity.getProduct()+"*"+entity.getNums();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			order.setId(orderid);
			order.setContent(content);
			try {
				activityOrderService.update(order);
			} catch (Exception e) {
				e.printStackTrace();
			};
		}
		red.addAttribute("id", activityId);
		return "redirect:/activity/order/list";
	}
	
	/**
	 * 匿名保存
	 * @param request
	 * @param activityId
	 * @param userName
	 * @param red
	 * @return
	 */
	@RequestMapping(value = "/save2")
	public String save2(HttpServletRequest request,@RequestParam String uuid,@RequestParam String userName,RedirectAttributes red ) {
		int userId = 0;
		
		String[] foods = request.getParameterValues("food");
		String[] nums = request.getParameterValues("num");
		
		Activity act = null;
		try {
			act = activityService.findEntityByUUID(uuid);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if(act == null)
		{
			red.addAttribute("uuid", uuid);
			return "redirect:list2";
		}
		
		Object orderId = 0;
		if(foods!=null && foods.length > 0 && userName != null && !userName.equals(""))
		{
			ActivityOrder order  = new ActivityOrder();
			order.setActivityId(act.getId());
			order.setContent("");
			order.setCreateTime(new Date());
			order.setUserName(userName);
			if(userName == null ||userName.equals(""))
			{
				red.addAttribute("uuid", uuid);
				return "redirect:list2";
			}
			
			try {
				orderId = activityOrderService.saveEntity(order);
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			String content = "";
			int orderid = Integer.parseInt(orderId+"");
			for(int i = 0; i < foods.length; i ++)
			{
				String nn = nums[i];
				if(nn == null || nn.length()==0)
				{
					nn = "1";
				}
				ActivityOrderDetail entity = new ActivityOrderDetail();
				entity.setActivityId(act.getId());
				entity.setProduct(foods[i]);;
				entity.setNums(Integer.parseInt(nn));
				entity.setPrice(0D);
				entity.setUserId(userId);
				entity.setOrderId(orderid);
				entity.setUserName(userName);
				
				try {
					if(foods[i] != null && !foods[i].equals(""))
					{
						activityOrderDetailService.saveEntity(entity);
						content += entity.getProduct()+"*"+entity.getNums();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			order.setId(orderid);
			order.setContent(content);
			try {
				activityOrderService.update(order);
			} catch (Exception e) {
				e.printStackTrace();
			};
		}
		red.addAttribute("uuid", uuid);
		return "redirect:list2";
	}
	
	
	@RequestMapping(value = "/list2")
	public String list2(RedirectAttributes redirectAttributes,@RequestParam("uuid") String uuid,Model model) {
		
		try {
//			String[] keyName = new String[]{};
//			String[] operate= new String[]{};
//			Object[] keyValue= new Object[]{};
			
			Activity activity = activityService.findEntityByUUID(uuid);
			
			model.addAttribute("activity", activity);
			
//			activityOrderDetailService.findEntityList(keyName, operate, keyValue, 100, 1);
			
			String sql = "select product,sum(nums) numx,sum(price) total_price from activity_order_detail where activity_id="+activity.getId()+" group by product";
			
			List<Map<String, String>> queryListMap = activityOrderDetailService.queryListMap(sql); 
			
			model.addAttribute("orderDetailList",queryListMap);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/activity/order-detail-list2";
	}
	
	@RequestMapping(value = "/list")
	public String list(RedirectAttributes redirectAttributes,@RequestParam("id") Long id,Model model) {
		
		try {
//			String[] keyName = new String[]{};
//			String[] operate= new String[]{};
//			Object[] keyValue= new Object[]{};
			
			Activity activity = activityService.findEntityById(id);
			
			model.addAttribute("activity", activity);
			
//			activityOrderDetailService.findEntityList(keyName, operate, keyValue, 100, 1);
			
			String sql = "select product,sum(nums) numx,sum(price) total_price from activity_order_detail where activity_id="+id+" group by product";
			
			List<Map<String, String>> queryListMap = activityOrderDetailService.queryListMap(sql); 
			
			model.addAttribute("orderDetailList",queryListMap);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/activity/order-detail-list";
	}
} 
				 
								