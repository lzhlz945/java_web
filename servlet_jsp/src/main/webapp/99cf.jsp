<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        table{
            width: 650px;
        }
    </style>
</head>
<body>

<%-- 练习一：在 jsp 页面中输出九九乘法口诀表 --%>
<h1 align="center">九九乘法口诀表</h1>
<table align="center">
    <%-- 外层循环遍历行 --%>
        <% for (int i = 1; i <= 9; i++) { %> <tr>
        <%-- 内层循环遍历单元格 --%>
            <% for (int j = 1; j <= i ; j++) { %>
            <td><%=j + "x" + i + "=" + (i*j)%></td> <% } %> </tr> <% }
    %>
</table>
</body>
</html>
