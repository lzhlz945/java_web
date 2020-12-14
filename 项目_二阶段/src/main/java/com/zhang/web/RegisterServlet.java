package com.zhang.web;

import com.zhang.pojo.User;
import com.zhang.service.UserService;
import com.zhang.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: ${PACKAGE_NAME}
 * @date:2020/12/14
 */
@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private UserService userService=new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        // 1、获取请求的参数
       String username = request.getParameter("username");
       String password = request.getParameter("password");
       String email = request.getParameter("email");
       String code = request.getParameter("code");
        User user = new User(null, username, password, email);
        if("abcd".equalsIgnoreCase(code)){
           if(userService.existUserName(username)){
               System.out.println("用户名已存在！");
               request.getRequestDispatcher("/pages/user/regist.html").forward(request,response);

           }else {
               userService.login(user);
               request.getRequestDispatcher("/pages/user/pages/user/regist_success.html").forward(request,response);
           }


       }else {
           System.out.println("验证码：+【"+code+"】"+"错误！");
           request.getRequestDispatcher("/pages/user/regist.html").forward(request,response);
       }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
