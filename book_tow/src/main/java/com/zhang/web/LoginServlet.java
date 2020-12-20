package com.zhang.web;

import com.zhang.pojo.User;
import com.zhang.service.UserService;
import com.zhang.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: ${PACKAGE_NAME}
 * @date:2020/12/14
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service=new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user=service.login(new User(null,username,password,null));
        if(user == null){
            System.out.println("用户不存在");

            request.setAttribute("msg","用户不存在或者，账号密码错误");
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        }else {
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}
