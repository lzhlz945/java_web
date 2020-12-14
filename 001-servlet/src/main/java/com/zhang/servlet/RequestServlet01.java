package com.zhang.servlet;

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
@WebServlet(name = "RequestServlet01")
public class RequestServlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String hobby = request.getParameter("hobby");
        System.out.println(username);
        System.out.println(password);
        System.out.println(hobby);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String uri = request.getRequestURI();
        StringBuffer url = request.getRequestURL();
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String hobby = request.getParameter("hobby");
        //1 先以 iso8859-1 进行编码
        // 2 再以 utf-8 进行解码
         username = new String(username.getBytes("iso-8859-1"), "UTF-8");
        System.out.println(username);
        System.out.println(password);
        System.out.println(hobby);
        System.out.println("remoteHost:"+remoteHost);
        System.out.println("remotePort:"+remotePort);
        System.out.println("uri:"+uri);
        System.out.println("url:"+url);
    }
}
