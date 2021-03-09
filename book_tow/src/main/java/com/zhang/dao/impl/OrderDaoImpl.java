package com.zhang.dao.impl;


import com.zhang.dao.OrderDao;
import com.zhang.pojo.Book;



public class OrderDaoImpl extends BaseDao implements OrderDao {

    @Override
    public void addBookMsg(Book book) {

        String sql="insert into order_book(booKName,bookId) values(?,?)";
        commonsUpdate(sql,book.getName(), book.getId());
    }
}
