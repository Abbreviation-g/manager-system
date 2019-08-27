package com.my.manager.common;

import org.springframework.http.HttpStatus;

public class CommonResult {
	private Integer code = HttpStatus.OK.value();
	private String message;
	private Object data;

	private CommonResult(Object data) {
		this(HttpStatus.OK, data);
	}

	private CommonResult(HttpStatus httpStatus, Object data) {
		this(httpStatus.value(), httpStatus.getReasonPhrase(), data);
	}

	private CommonResult(Integer code, String message, Object data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static CommonResult successResult(Object data) {
		return new CommonResult(data);
	}

	public static CommonResult errorResult(HttpStatus httpStatus, Object data) {
		return new CommonResult(httpStatus, data);
	}

	public static CommonResult errorResult(HttpStatus httpStatus, String message, Object data) {
		return new CommonResult(httpStatus.value(), message, data);
	}
}
