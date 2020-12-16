<%@ page import="java.util.List" %>
<%@ page import="com.zhang.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table
        { border: 1px blue solid;
            width: 600px;
            border-collapse: collapse;
        }
        td,th{ border: 1px blue solid;
        }
    </style>
</head>
<body>
  <% List<Student> stuList = (List<Student>) request.getAttribute("stuList");%>
       <div align="center">
           <table>
               <tr><td>编号</td>
                   <td>姓名</td>
                   <td>年龄</td>
                   <td>成绩</td>
                   <td>操作</td>
               </tr>
       <% for (int i = 0; i <stuList.size(); i++) {
         %><tr>
               <td><%= stuList.get(i).getId()%></td>
               <td><%= stuList.get(i).getName()%></td>
               <td><%= stuList.get(i).getAge()%></td>
               <td><%= stuList.get(i).getScore()%></td>
               <td>
                   <a href="">修改</a>
                   <a href="">删除</a>
               </td>
           </tr>
               <%
}        %>
           </table>
       </div>

</body>
</html>
