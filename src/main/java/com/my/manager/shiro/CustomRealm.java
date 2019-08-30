package com.my.manager.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.my.manager.bean.UserBean;
import com.my.manager.service.UserService;

public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Override
	public String getName() {
		return "明文密码校验realm";
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		UserBean userBean = userService.queryUserByUsername(username);
		if (userBean == null) {
			throw new UnknownAccountException();
		}

		return new SimpleAuthenticationInfo(userBean, userBean.getPassword(), getName());
	}
}
