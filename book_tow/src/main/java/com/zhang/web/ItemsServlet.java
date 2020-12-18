package com.zhang.web;

import com.zhang.pojo.Book;
import com.zhang.pojo.Cart;
import com.zhang.pojo.CartItem;
import com.zhang.service.BookService;
import com.zhang.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.web
 * @date:2020/12/18
 */
public class ItemsServlet extends BaseServlet {
    private BookService bookService=new BookServiceImpl();
    protected void addItems(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        //获取Id查询商品信息
        String id = req.getParameter("id");

        Book book = bookService.queryBookById(Integer.valueOf(id));

        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if(cart == null){
         cart = new Cart();
         session.setAttribute("cart",cart);
        }

         cart.addItems(cartItem);

         // 最后一个添加的商品名称
        req.getSession().setAttribute("lastName", cartItem.getName());

        // 重定向回原来商品所在的地址页面
        resp.sendRedirect(req.getHeader("Referer"));
        System.out.println(req.getHeader("Referer"));


    }
}
