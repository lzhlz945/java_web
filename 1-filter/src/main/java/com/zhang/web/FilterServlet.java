package com.zhang.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterServlet extends BaseServlet {
    protected void login(HttpServletRequest req, HttpServletResponse resp)throws Exception{
        resp.setContentType("text/html; charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("admin".equals(username) && "123456".equals(password)) {
            req.getSession().setAttribute("user",username);
            resp.getWriter().write("录 登录 成功！！！");
            req.getRequestDispatcher("/admin/sucess.jsp").forward(req,resp);
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }



    }
}
