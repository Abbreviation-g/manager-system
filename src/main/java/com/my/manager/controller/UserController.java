package com.my.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.manager.common.CommonResult;

@Controller("/user")
public class UserController {
	
	@GetMapping("/test")
	@ResponseBody
	public Object test() {
		return CommonResult.successResult("test");
	}
	
	@PostMapping(value = "/login")
	public Object login(@RequestParam String username,@RequestParam String password) {
		System.out.println("UserController.login()");
		System.out.println(username+": "+password);
		return "redirect:/index";
	}

	@PostMapping("/logout")
	public String logout() {
		return "redirect:/login";
	}
}
