<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="com.zhang.Student" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/4
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            width: 500px;
            border: 1px solid red;
            border-collapse: collapse;
        }
        th , td{
            border: 1px solid red;
        }
    </style>
</head>
<body>
    <%--1.遍历1到10，输出
        begin属性设置开始的索引
        end 属性设置结束的索引
        var 属性表示循环的变量(也是当前正在遍历到的数据)
        for (int i = 1; i < 10; i++)

    <table border="1">
        <c:forEach begin="1" end="10" var="i">
            <tr>
                <td>第${i}行</td>
            </tr>
        </c:forEach>
    </table>--%>
    <hr>
   <%-- 2.遍历Object数组
        for (Object item: arr)
        items 表示遍历的数据源（遍历的集合）
        var 表示当前遍历到的数据

    <%
        request.setAttribute("arr", new String[]{"18610541354","18688886666","18699998888"});
    %>
        <%--
            items 表示遍历的集合
            var 表示遍历到的数据
            begin表示遍历的开始索引值
            end 表示结束的索引值
            step 属性表示遍历的步长值
            varStatus 属性表示当前遍历到的数据的状态
            for（int i = 1; i < 10; i+=2）
        --%>
    <c:forEach items="${ requestScope.arr }" var="item">
        ${ item } <br>
    </c:forEach> --%>
    <hr>
    <%
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
//        for ( Map.Entry<String,Object> entry : map.entrySet()) {
//        }
        request.setAttribute("map", map);
    %>
    <c:forEach items="${ requestScope.map }" var="entry">
        <h1>${entry.key} = ${entry.value}</h1>
    </c:forEach>
    <hr>
    <%--4.遍历List集合---list中存放 Student类，有属性：编号，用户名，密码，年龄，电话信息--%>
    <%
        List<Student> studentList=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            studentList.add(new Student(i,"name"+i,i*2,i*11));
        }
        session.setAttribute("stuList",studentList);
    %>
         <div align="center">
         <table>
             <tr>
                 <th>序号</th>
                 <th>id</th>
                 <th>姓名</th>
                 <th>年龄</th>
                 <th>成绩</th>
                 <th>操作</th>
             </tr>
           <c:forEach begin="1" step="2" end="20" items="${sessionScope.stuList}" var="stu" varStatus="flag">
             <tr>
                 <td>${flag.count}</td>
                 <td>${stu.id}</td>
                 <td>${stu.name}</td>
                 <td>${stu.age}</td>
                 <td>${stu.score}</td>
                 <td><a href="">删除/修改</a></td>
             </tr>
           </c:forEach>
         </table>
         </div>
</body>
</html>
