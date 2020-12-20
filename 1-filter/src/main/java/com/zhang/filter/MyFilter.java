package com.zhang.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        if(user==null){
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }else {
            filterChain.doFilter(request,response);
        }


    }
}
