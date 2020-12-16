package com.zhang;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       /* System.out.println("hhaha");
        //判断是不是分段的文件上传
        if(ServletFileUpload.isMultipartContent(request)){
            //创建FileItemFactory
            FileItemFactory factory=new DiskFileItemFactory();

            ServletFileUpload fileUpload= new ServletFileUpload(factory);
            try {
                List<FileItem> fileItemList = fileUpload.parseRequest(request);
                for (FileItem fileItem : fileItemList) {
                  //判断是不是普通的标签
                    if(fileItem.isFormField()){
                        System.out.println(fileItem.getFieldName()); //获取name
                        System.out.println(fileItem.getString("UTF-8")); //获取values

                    }else {

                        System.out.println(fileItem.getFieldName());  //表单名
                        System.out.println(fileItem.getName()); //获取表单的文件上传名

                        fileItem.write(new File("E:\\" + fileItem.getName()));


                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }



        }

    }*/

       //先判断是不是分段文件
        if(ServletFileUpload.isMultipartContent(request)){
            //创建FileItemFactory
            FileItemFactory factory=new DiskFileItemFactory();
            ServletFileUpload servletFileUpload=new ServletFileUpload(factory);

            try {
                //解析传过来的表单
                List<FileItem> fileItems = servletFileUpload.parseRequest(request);
                for (FileItem fileItem : fileItems) {
                //区分表单
                    if(fileItem.isFormField()){
                        System.out.println(fileItem.getFieldName());
                        System.out.println(fileItem.getString("UTF-8"));
                    }else {
                        System.out.println(fileItem.getFieldName());
                        System.out.println(fileItem.getName());

                        fileItem.write(new File("E:\\"+fileItem.getName()));

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }


    }


}
