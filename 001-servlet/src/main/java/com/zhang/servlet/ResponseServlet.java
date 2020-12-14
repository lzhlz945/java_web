package com.zhang.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: ${PACKAGE_NAME}
 * @date:2020/12/14
 */
@WebServlet(name = "ResponseServlet")
public class ResponseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //此方法一定要在获取流对象前有效
        response.setContentType("text/html;charset=utf-8");
        //设置响应
       /* PrintWriter writer = response.getWriter();
        writer.write("d等等");*/
        FileInputStream fis=new FileInputStream("E:\\java_web\\001-servlet\\src\\timg.jpg");
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] bytes=new byte[1024];
        int n;
        while ((n=fis.read(bytes))!=-1){
            outputStream.write(bytes,0,n);
        }
    }
}
