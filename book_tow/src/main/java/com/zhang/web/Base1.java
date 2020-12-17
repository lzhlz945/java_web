package com.zhang.web;

import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.web
 * @date:2020/12/17
 */
public class Base1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Part action = req.getPart("action");
        //利用反射获取被方法
        Method action1 = this.getClass().getDeclaredMethod("action", HttpServletRequest.class, HttpServletResponse.class);
        action1.setAccessible(true);
        action1.invoke(this,req,resp);

    }
}
