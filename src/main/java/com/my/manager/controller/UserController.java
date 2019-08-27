package com.my.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.manager.common.CommonResult;

@Controller("/user")
public class UserController {
	
	@GetMapping("/test")
	@ResponseBody
	public Object test() {
		return CommonResult.successResult("test");
	}
}
