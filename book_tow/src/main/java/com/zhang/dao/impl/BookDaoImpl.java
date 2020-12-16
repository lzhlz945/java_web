package com.zhang.dao.impl;

import com.zhang.JdbcUtils.JdbcUtils;
import com.zhang.dao.BookDao;
import com.zhang.pojo.Book;

import java.sql.Connection;
import java.util.List;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.dao.impl
 * @date:2020/12/16
 */
public class BookDaoImpl extends BaseDao implements BookDao {
    private static Connection con=JdbcUtils.getConnection();
    @Override
    public void addBook(Book book) {
        String sql = "insert into t_book(`name`,`author`,`price`,`sales`,`stock`,`img_path`) values(?,?,?,?,?,?)";
        commonsUpdate(con,sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
    }

    @Override
    public void deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        commonsUpdate(con,sql,id);
    }

    @Override
    public void updateBook(Book book) {
        String sql = "update t_book set `name`=?,`author`=?,`price`=?,`sales`=?,`stock`=?,`img_path`=? where id = ?";
        commonsUpdate(con,sql,book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book where id = ?";
        Book book = selectObject(con, sql, Book.class, id);
        return book;

    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` imgPath from t_book";

        return selectList(con,sql,Book.class);
    }
}
