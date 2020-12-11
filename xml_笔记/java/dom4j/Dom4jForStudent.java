package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import pojo.Student;

import java.io.FileInputStream;
import java.io.FileOutputStream;
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
            System.out.println(student.asXML());
            //遍历父级获取的子标签，再用这个标签获取里面的标签
            String name = student.elementText("name");
            String age = student.elementText("age");
            String addr=student.elementText("addr");
            //获取student标签的 num的内容
            String num = student.attributeValue("num");
            System.out.println(new Student(num,name,Integer.parseInt(age),addr));
        }


    }
    public Document createDocument() {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement( "root" );

        Element author1 = root.addElement( "author" )
                .addAttribute( "name", "James" )
                .addAttribute( "location", "UK" )
                .addText( "James Strachan" );

        Element author2 = root.addElement( "author" )
                .addAttribute( "name", "Bob" )
                .addAttribute( "location", "US" )
                .addText( "Bob McWhirter" );

        return document;
    }

    public Document createDoc(){
        Document document = DocumentHelper.createDocument();
        Element students = document.addElement("students");
        Element student1 = students.addElement("student");
        student1.addAttribute("num","001");
        student1.addElement("name").addText("狼崽");
        student1.addElement("age").addText("20");

        Element student2 = students.addElement("student");
        student2.addAttribute("num","002");
        student2.addElement("name").addText("星儿");
        student2.addElement("age").addText("18");



        return document;
    }

    public static void main(String[] args) throws Exception{
        Dom4jForStudent dom4jForStudent = new Dom4jForStudent();
        Document document = dom4jForStudent.createDocument();
//      System.out.println(document.asXML());
        Document doc = dom4jForStudent.createDoc();
        FileOutputStream outputStream=new FileOutputStream("E:\\java_web\\xml_笔记\\java\\test.xml");
        String s = doc.asXML();

        char flag='>';
        StringBuffer buffer1=new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            buffer1.append(s.charAt(i));
            if(s.charAt(i)==flag){
            buffer1.append('\n');


            }
        }

        String s1 = buffer1.toString();
        System.out.println(s1);
        byte[] bytes = s1.getBytes();
       outputStream.write(bytes,0,bytes.length);


        System.out.println(doc.asXML());

    }
}
