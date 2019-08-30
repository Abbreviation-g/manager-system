package com.my.manager.controller;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.manager.bean.GoodsBean;
import com.my.manager.bean.UserBean;
import com.my.manager.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	GoodsService goodsService;

	@RequestMapping("/queryAll")
	public String queryAllGoods(Model model) {
		Subject subject = SecurityUtils.getSubject();
		Object principal = subject.getPrincipal();
		if (principal instanceof UserBean) {
			UserBean userBean = (UserBean) principal;
			String username = userBean.getUsername();
			model.addAttribute("username", username);
		}
		if(subject.isAuthenticated()) {
			List<GoodsBean> goodsList = goodsService.queryAllGoods();
			if(subject.hasRole("admin")){
				model.addAttribute("goodsList", goodsList.get(1));
			} else {
				model.addAttribute("goodsList",goodsList.get(0));
			}
		}

		return "/goods/showGoods";
	}

	public static void main(String[] args) {

	}
}
