package com.my.manager.bean;

import java.util.List;

import lombok.Data;

@Data
public class UserBean {
    private Long id;

    private String username;

    private String password;

    private String salt;
    
    private List<RoleBean> roleBeans;

	
}
