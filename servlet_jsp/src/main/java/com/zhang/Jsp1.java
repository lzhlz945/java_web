package com.zhang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang
 * @date:2020/12/15
 */
@WebServlet(name = "Jsp1")
public class Jsp1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Student> stuList=new ArrayList<>();
        stuList.add(new Student(1,"zs",20,80));
        stuList.add(new Student(2,"ls",22,70));
        stuList.add(new Student(3,"ww",20,90));
        stuList.add(new Student(4,"zl",20,790));
        req.setAttribute("stuList",stuList);
        req.getRequestDispatcher("/stu.jsp").forward(req,resp);
    }
}
