package com.zhang.dao.impl;

import com.zhang.JdbcUtils.JdbcUtils;
import com.zhang.dao.UserDao;
import com.zhang.pojo.User;

import java.sql.Connection;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.dao.impl
 * @date:2020/12/14
 */
public class UserDaoImpl extends BaseDao implements UserDao{
    //查询用户是否存在
      private   Connection con = JdbcUtils.getConnection();
    @Override
    public User queryUserName(String username) {
        String sql="SELECT username from t_user WHERE username=?";

        return selectObject(con,sql,User.class,username);
    }

    //注册
    @Override
    public User login(User user) {
        String sql="SELECT id,username,password,email from t_user WHERE username=? and password=?";
        User user1 = selectObject(con, sql, User.class, user.getUsername(), user.getPassword());
        return user1;
    }

    @Override
    public User registerUser(User user) {
        String sql = "insert into t_user(`username`,`password`,`email`) values(?,?,?)";
        commonsUpdate(con,sql,user.getUsername(),user.getPassword(),user.getEmail());
        String sql1="SELECT username,password from t_user WHERE username=? and password=?";
        User user1 = selectObject(con, sql, User.class, user.getUsername(), user.getPassword());
        return user1;
    }
}
