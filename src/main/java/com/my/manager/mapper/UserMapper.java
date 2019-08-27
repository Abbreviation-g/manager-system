package com.my.manager.mapper;

import com.my.manager.bean.UserBean;

public interface UserMapper {
    UserBean queryUserByUsername(String username);

    UserBean queryUserById(Integer id);
}
