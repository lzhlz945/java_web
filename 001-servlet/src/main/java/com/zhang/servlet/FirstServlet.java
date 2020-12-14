package com.zhang.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Set;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: ${PACKAGE_NAME}
 * @date:2020/12/14
 */
@WebServlet(name = "FirstServlet")
public class FirstServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("hello|doPost");
    }

    /*@Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String method = req.getMethod();
        if(method.equals("doPost")){
            System.out.println("dopost方法被调用了");
        }else {
            System.out.println("doget方法被调用了");

        }
    }*/

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext servletContext = request.getServletContext();
        String contextPath = servletContext.getContextPath();
        String name = servletContext.getInitParameter("a");
        String realPath = servletContext.getRealPath("/");
        String realPath1 = servletContext.getRealPath("css");
        String realPath2 = servletContext.getRealPath("1.jpg");
        System.out.println(name);
        System.out.println("当前工程路径"+contextPath);
        System.out.println("工程部署路径"+realPath);
        System.out.println("工程下css的绝对路径"+realPath1);
        System.out.println("工程下1.jpg的绝对路径"+realPath2);
        System.out.println("hello|doGet");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String name = config.getInitParameter("name");
        String url = config.getInitParameter("url");
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            System.out.println(s);
        }
        System.out.println(name+":"+url);
        System.out.println("我自己做了其他的事情");
    }
}
