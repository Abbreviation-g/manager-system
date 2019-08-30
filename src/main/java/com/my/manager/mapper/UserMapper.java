package com.my.manager.mapper;

import java.util.List;

import com.my.manager.bean.AuthBean;
import com.my.manager.bean.RoleBean;
import com.my.manager.bean.UserBean;

public interface UserMapper {
    UserBean queryUserByUsername(String username);

    UserBean queryUserById(Long id);
    
    List<RoleBean> queryRoleByUserId(Long userId);
    
    List<AuthBean> queryAuthByRoleId(Long roleId);
}
