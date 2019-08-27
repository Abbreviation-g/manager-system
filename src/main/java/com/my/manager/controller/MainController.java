package com.my.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.manager.common.CommonResult;

@Controller
public class MainController {
	@GetMapping("/")
	@ResponseBody
	public Object main() {
		String result = "This is a manager system. ";
		return CommonResult.successResult(result);
	}
	
	@GetMapping("/errorpage")
	@ResponseBody
	public Object error() {
		throw new RuntimeException("throw a exception. ");
	}
}
