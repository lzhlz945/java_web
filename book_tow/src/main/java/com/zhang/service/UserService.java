package com.zhang.service;

import com.zhang.pojo.User;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.service
 * @date:2020/12/14
 */
public interface UserService {
    //验证用户名
    boolean existUserName(String username);

    //登录
    User login(User user);


    //注册
    User registUser(User user);


}
