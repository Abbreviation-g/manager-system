package com.my.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.my.manager.bean.GoodsBean;
import com.my.manager.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	GoodsService goodsService;

    @RequestMapping("/queryAll")
    public String queryAllGoods(Model model) {
        List<GoodsBean> goodsList = goodsService.queryAllGoods();
        model.addAttribute("goodsList", goodsList);
//        String username = QueryUserNameUtils.getUserName();
//        model.addAttribute("username", username);
        return "/goods/showGoods";
    }

    public static void main(String[] args) {
		
    	
	}
}
