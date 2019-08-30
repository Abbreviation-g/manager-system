package com.my.manager.config.exception;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.manager.common.CommonResult;

//@Controller
public class NotFoundException implements ErrorController {
    @Override
    public String getErrorPath() {
        return "/not_found";
    }
 
    @RequestMapping(value = {"/not_found"})
    @ResponseBody
    public Object error() {
        return CommonResult.errorResult(HttpStatus.NOT_FOUND, "Request not found. ");
    }
}

