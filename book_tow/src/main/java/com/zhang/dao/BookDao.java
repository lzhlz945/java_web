package com.zhang.dao;

import com.zhang.pojo.Book;

import java.util.List;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.dao
 * @date:2020/12/16
 */
public interface BookDao {
    //添加图书
    void addBook(Book book);

    //根据id删除
    void deleteBookById(Integer id);

    //更新book
    void updateBook(Book book);

    //根据id查询
    Book queryBookById(Integer id);

    //查询批量记录
    List<Book> queryBooks();

    int getCount();

    List<Book> getItems(int begin, int pageSize);
}
