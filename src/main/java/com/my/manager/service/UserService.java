package com.my.manager.service;

import com.my.manager.bean.UserBean;

public interface UserService {
	UserBean queryUserByUsername(String username);
}
