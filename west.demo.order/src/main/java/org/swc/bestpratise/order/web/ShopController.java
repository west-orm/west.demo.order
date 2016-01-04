package org.swc.bestpratise.order.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.swc.bestpratise.order.entity.Shop;
import org.swc.bestpratise.order.service.ShopService;

import com.bucuoa.west.orm.extend.Page;

/**
 * 商家
 * 
 * @author jake
 *
 */
@Controller
@RequestMapping(value = "/shop")
public class ShopController {

	@Autowired
	private ShopService shopService;

	@RequestMapping(value = "/add")
	public String add(RedirectAttributes redirectAttributes, Shop entity) {
		
		System.out.println("add shop");
		return "/shop/add";
	}

	@RequestMapping(value = "/save")
	public String save(RedirectAttributes redirectAttributes, Shop entity) {

		entity.setCreater("");
		entity.setCreateTime(new Date());

		try {
			Object idx = shopService.saveEntity(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list";
	}

	@RequestMapping(value = "/saveapi")
	@ResponseBody
	public void save2(RedirectAttributes redirectAttributes, Shop entity) {

		entity.setCreater("");
		entity.setCreateTime(new Date());

		try {
			Object idx = shopService.saveEntity(entity);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, Model model, Page page) {

		try {

			Page entityPage = shopService.getEntityPage(request);

			model.addAttribute("page", entityPage);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "/shop/list";
	}

	@RequestMapping(value = "/delete")
	public String delete(@RequestParam("id") Long id) {

		try {

			boolean deleteEntityById = shopService.deleteEntityById(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:list";
	}

}