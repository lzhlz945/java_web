package com.zhang.filter;

import com.zhang.JdbcUtils.JdbcUtils;

import javax.servlet.*;
import java.io.IOException;

public class TranctionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        try {
            filterChain.doFilter(servletRequest,servletResponse);//执行过滤器 调度资源
            JdbcUtils.commitAndclose();
        } catch (Exception e) {
            JdbcUtils.rollbackAndclose();
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    @Override
    public void destroy() {

    }
}
