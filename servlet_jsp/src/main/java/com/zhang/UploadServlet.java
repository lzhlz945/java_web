package com.zhang;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author: create by zhl
 * @version: v1.0
 * @description: ${PACKAGE_NAME}
 * @date:2020/12/16
 */
@WebServlet(name = "UploadServlet")
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1、判断是不是分段文件
        if(ServletFileUpload.isMultipartContent(request)){
            //获取FileItemFactory
            FileItemFactory factor=new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factor);
            //获取表单list集合信息
            try {
                List<FileItem> items = upload.parseRequest(request);
                for(FileItem item:items){
                    //判断表单是否是特殊的，
                    if(item.isFormField()){
                        System.out.println(item.getFieldName());
                        System.out.println(item.getString("UTF-8"));
                    }else {
                        System.out.println(item.getFieldName());
                        System.out.println(item.getName());
                        item.write(new File("E:\\"+item.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }


        }


    }


}
