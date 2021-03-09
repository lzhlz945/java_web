package dom4j;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;


import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: dom4j
 * @date:2020/12/11
 */
public class Dom4jTest {
    @Test
    public void test01()throws Exception{
       //解析流
        SAXReader saxReader = new SAXReader();
        //获取xml文件对象
        Document read = saxReader.read("book.xml");
//        System.out.println(read);
        //获取xml中的父级标签
        Element rootElement = read.getRootElement();

        List<Element> book = rootElement.elements();
        List<Book> list=new ArrayList<>();
        for (Element o : book) {

            String name = o.elementText("name");
            System.out.println(name);
            String price = o.elementText("price");
            System.out.println(price);
            String author = o.elementText("author");
            System.out.println(author);
            String sn = o.attributeValue("SN");
            System.out.println(sn);
            Book book1 = new Book(sn,name,author, BigDecimal.valueOf(Long.parseLong(price)));
            list.add(book1);


        }
        for (Book book1 : list) {
            System.out.println(book1);
        }

    }

}
