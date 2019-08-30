package com.my.manager.bean;

import java.util.List;

import lombok.Data;

@Data
public class RoleBean {
	private Long id;
	
	private String roleName;
	
	private List<AuthBean> authBeans;

	
}
