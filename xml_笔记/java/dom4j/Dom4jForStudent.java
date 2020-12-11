package dom4j;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import pojo.Student;

import java.util.List;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: dom4j
 * @date:2020/12/11
 */
public class Dom4jForStudent {
    @Test
    public void test() throws  Exception{
        //创建解析流
        SAXReader reader = new SAXReader();
        //用流读取文件
        Document document = reader.read("student.xml");

        //用document对象去读取父级标签
        Element rootElement = document.getRootElement();
        //用父级 去获取子标签 element
        List<Element> Students = rootElement.elements();
        for (Element student : Students) {
            //遍历父级获取的子标签，再用这个标签获取里面的标签
            String name = student.elementText("name");
            String age = student.elementText("age");
            String addr=student.elementText("addr");
            //获取student标签的 num的内容
            String num = student.attributeValue("num");
            System.out.println(new Student(num,name,Integer.parseInt(age),addr));
        }


    }
}
