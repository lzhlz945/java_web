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
    //验证用户名
    private UserDao userDao=new UserDaoImpl();
    @Override
    public boolean existUserName(String username) {

        if(userDao.queryUserName(username) != null){
            return false;
        }
        return  true;
    }

    //注册
    @Override
    public void login(User user) {

        userDao.login(user);
    }
}
