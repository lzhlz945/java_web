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
public class Listener1 implements ServletContextListener {
    /**
     * 监听器，监听事务的变化
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听器被创建了！");
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("ss","u1s1");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
