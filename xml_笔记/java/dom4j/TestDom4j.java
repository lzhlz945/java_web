package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import pojo.Book;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: dom4j
 * @date:2020/12/14
 */
public class TestDom4j {
    @Test
    public void test01() throws Exception{
        //创建流读取xml文件
        SAXReader reader = new SAXReader();
        //读取文件
        Document read = reader.read("book.xml");
        //读取父级标签
        Element rootElement = read.getRootElement();
        //根据父级读取包含的标签
        List<Element> books = rootElement.elements();

        List<Book> list=new ArrayList<>();
        //遍历
        for (Element book : books) {

            String sn = book.attributeValue("SN");
            String name = book.elementText("name");
            String price = book.elementText("price");
            String author = book.elementText("author");
            Book book1 = new Book(sn, name, author, new BigDecimal(price));
            list.add(book1);
        }

        for (Book book : list) {
            System.out.println(book);
        }


    }
    public Document test011(){
        Document document = DocumentHelper.createDocument();

        Element books = document.addElement("books");
        Element book = books.addElement("book");
        Element book2 = books.addElement("book");
        Element book1 = book.addAttribute("sn", "001");
        book1.addElement("name").addText("狼崽");
        book1.addElement("age").addText("20");
        Element book3 = book2.addAttribute("sn", "002");
        book3.addElement("name").addText("星儿");
        book3.addElement("age").addText("20");
        System.out.println(document.asXML());

        return document;

    }
    @Test
    public void test03(){
        TestDom4j testDom4j = new TestDom4j();
        testDom4j.test011();

    }
}
