/*******************************************************************************
 * Copyright (c) 2005, 2014 springside.github.io
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *******************************************************************************/
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
public class IndexController {
	@Autowired	
	UsersService usersService;

	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public String door(RedirectAttributes redirectAttributes) {
	
		return "login";
	}
	
	@RequestMapping(value = "/header",method = RequestMethod.GET)
	public String header(HttpSession httpSession) {
	
		return "/common/header";
	}
	
	@RequestMapping(value = "/sidebar",method = RequestMethod.GET)
	public String sidebar(HttpSession httpSession) {
	
		return "/common/sidebar";
	}
	@RequestMapping(value = "/setting",method = RequestMethod.GET)
	public String setting(HttpSession httpSession) {
	
		return "/common/setting";
	}
	@RequestMapping(value = "/dologin")
	public String dologin(@RequestParam("username") String username,@RequestParam("password") String password,HttpSession httpSession) throws Exception {
		
		Users user = null;
		try {
			user = usersService.findEntityBy(username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "redirect:/login";
		}
		
		if(user != null)
		{
			 httpSession.setAttribute("user", user);
			 System.out.println(username+"+"+password);
			 return "redirect:dashboard";
		}else
		{
			System.out.println(username+"+"+password);
			return "redirect:login";
		}
		
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession httpSession) throws Exception {
		httpSession.removeAttribute("user");;
		System.out.println("leave");
		return "redirect:login";
	}
	
	@RequestMapping(value = "/dashboard")
	public String dashboard() throws Exception {
		System.out.println("dashboard");
		return "dashboard";
	}

}
