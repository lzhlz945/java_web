package com.zhang.service.impl;

import com.zhang.dao.BookDao;
import com.zhang.dao.OrderDao;
import com.zhang.dao.impl.BookDaoImpl;
import com.zhang.dao.impl.OrderDaoImpl;
import com.zhang.pojo.Book;
import com.zhang.pojo.Page;
import com.zhang.service.BookService;

import java.util.List;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: com.zhang.service.impl
 * @date:2020/12/16
 */
public class BookServiceImpl implements BookService {
    private BookDao bookDao=new BookDaoImpl();
    private OrderDao orderDao=new OrderDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
//     int a=10/0;
        orderDao.addBookMsg(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {

        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    //分页操作
    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        if(pageNo < 1){
            pageNo=1;
        }
        //获取总计数
        int count=bookDao.getCount();


        int pageTotal=count/pageSize;
        if(count % pageSize > 1){

            pageTotal+=1;
        }
        if(pageNo > pageTotal){
            pageNo=pageTotal;
        }
        int begin=(pageNo-1)*pageSize;
        //获取分页数据items
        List<Book> bookList= bookDao.getItems(begin,pageSize);
        Page<Book> page = new Page<>();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setPageTotal(pageTotal);
        page.setPageTotalCount(count);
        page.setItems(bookList);


        return page;
    }
}
