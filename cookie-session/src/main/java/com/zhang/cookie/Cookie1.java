package com.zhang.cookie;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: ${PACKAGE_NAME}
 * @date:2020/12/17
 */
@WebServlet(name = "Cookie01")
public class Cookie1 extends BaseServlet {
    protected void cookie001(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

        javax.servlet.http.Cookie cookie1=new javax.servlet.http.Cookie("key1","value1");
        cookie1.setMaxAge(60*60*10);
        cookie1.setPath("/");
        resp.addCookie(cookie1);
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("cookie1创建了");

    }   
    protected void cookie002(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

        javax.servlet.http.Cookie[] cookies = req.getCookies();
        for (javax.servlet.http.Cookie cookie : cookies) {

        String name = cookie.getName();
        PrintWriter writer = resp.getWriter();
        writer.write(name);
        }

    }
  
}
