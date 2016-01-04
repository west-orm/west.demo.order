package org.swc.bestpratise.order.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.swc.bestpratise.order.entity.Users;
import org.swc.bestpratise.order.service.UsersService;

/**
 * 用户注册的Controller.
 * 
 * @author calvin
 */
@Controller
@RequestMapping(value = "/user")
public class UsersController { 
	@Autowired	
	UsersService usersService;
	
	@RequestMapping(value="register",method = RequestMethod.POST)
	public String register(RedirectAttributes redirectAttributes,@RequestParam String userName,
			@RequestParam String passwd,@RequestParam String realName,@RequestParam String passwd2,HttpSession httpSession) {
		Users user = new Users();
		user.setUserName(userName);
		user.setPassword(passwd);
		user.setRealName(realName);
		try {
			 Object idx = usersService.saveEntity(user);
			 user.setId(Integer.parseInt(idx+""));
			 
			 httpSession.setAttribute("user", user);

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/login";
		}
//		redirectAttributes.addFlashAttribute("myEntityList", myEntityList);
		return "redirect:/dashboard";
	}
}
			 
								