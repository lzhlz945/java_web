package com.zhang.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.web
 * @date:2020/12/18
 */
public class KpatchServlet extends BaseServlet {
    protected void kpatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       HttpSession session = req.getSession();
       String token= (String) session.getAttribute(KAPTCHA_SESSION_KEY);
       System.out.println(token);
       session.removeAttribute(KAPTCHA_SESSION_KEY);
        String code = req.getParameter("code");
        String username = req.getParameter("username");
        if(null != token && token.equalsIgnoreCase(code)){
            System.out.println("登录成功："+username);

            resp.sendRedirect(req.getContextPath()+"/ok.jsp");
        }else {
            System.out.println("请不要重复提交表单");
        }



    }
}
