package com.zhang.service.impl;

import com.zhang.dao.UserDao;
import com.zhang.dao.impl.UserDaoImpl;
import com.zhang.pojo.User;
import com.zhang.service.UserService;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.service.impl
 * @date:2020/12/14
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao=new UserDaoImpl();

    //验证用户名
    @Override
    public boolean existUserName(String username) {

        if(userDao.queryUserName(username) == null){
            return false;
        }
        return  true;
    }

    //登录
    @Override
    public User login(User user) {
        return userDao.login(user);
    }

    //注册
    @Override
    public User registUser(User user) {
      return   userDao.registerUser(user);
    }


}
