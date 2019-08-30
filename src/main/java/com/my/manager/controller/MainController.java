package com.my.manager.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	@GetMapping("/")
	public String main() {
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login() {
		System.out.println("MainController.login()");
		Subject subject = SecurityUtils.getSubject();
		System.out.println(subject.isAuthenticated());
		return "login";
	}
	
	@GetMapping("/index")
	public String index() {
		Subject subject = SecurityUtils.getSubject();
		System.out.println(subject.isAuthenticated());
		return "index";
	}
	
	@GetMapping("/errorpage")
	@ResponseBody
	public Object error() {
		throw new RuntimeException("throw a exception. ");
	}
}
