package com.my.manager.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

	@Bean
	public Realm realm() {
		CustomRealm realm = new CustomRealm();
		return realm;
	}

	@Bean
	public SecurityManager securityManager(Realm realm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(realm);

		return securityManager;
	}
	
	@Bean
	public ShiroFilterFactoryBean filter(SecurityManager securityManager) {
		ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
		filterFactoryBean.setSecurityManager(securityManager);
		
		filterFactoryBean.setUnauthorizedUrl("/");
		
		Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
		filterChainDefinitionMap.put("/", DefaultFilter.anon.name());
//		filterChainDefinitionMap.put("/logout", DefaultFilter.logout.name());
		filterChainDefinitionMap.put("/**", DefaultFilter.authc.name());
		
		filterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		filterFactoryBean.setLoginUrl("/login");
		filterFactoryBean.setSuccessUrl("/index");
		
		return filterFactoryBean;
	}
}
