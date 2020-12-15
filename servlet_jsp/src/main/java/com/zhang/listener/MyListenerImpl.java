package com.zhang.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.listener
 * @date:2020/12/15
 */
public class MyListenerImpl implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("qj","qjqj");
        System.out.println("servletContext监听器被创建了！！");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("servletContext监听器被销毁了！！");
    }
}
