package com.my.manager.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.manager.common.CommonResult;

@Controller("/user")
public class UserController {
	
	@GetMapping("/test")
	@ResponseBody
	public Object test() {
		return CommonResult.successResult("test");
	}
	
	@PostMapping("/logout")
	public String logout() {
		System.out.println("UserController.logout()");
		return "redirect:/login";
	}
	
	@GetMapping("/logout")
	public String getLogout() {
		System.out.println("UserController.getLogout()");
		SecurityUtils.getSubject().logout();
		Subject subject = SecurityUtils.getSubject();
		System.out.println(subject.isAuthenticated());
		return "redirect:/login";
	}

}
