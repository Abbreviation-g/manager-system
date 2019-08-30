package com.my.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.manager.bean.AuthBean;
import com.my.manager.bean.RoleBean;
import com.my.manager.bean.UserBean;
import com.my.manager.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	@Override
	public UserBean queryUserByUsername(String username) {
		UserBean userBean = userMapper.queryUserByUsername("admin");

		List<RoleBean> roleBeans = userMapper.queryRoleByUserId(userBean.getId());

		if(! roleBeans.isEmpty()) {
			userBean.setRoleBeans(roleBeans);
			for (RoleBean roleBean : roleBeans) {
				List<AuthBean> authBeans = userMapper.queryAuthByRoleId(roleBean.getId());
				if(!authBeans.isEmpty())
					roleBean.setAuthBeans(authBeans);
			}
		}
		return userBean;
	}

}
