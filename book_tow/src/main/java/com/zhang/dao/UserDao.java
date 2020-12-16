package com.zhang.dao;

import com.zhang.pojo.User;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.dao
 * @date:2020/12/14
 */
public interface UserDao {

    User queryUserName(String username);


    User login(User user);

    User registerUser(User user);
}
