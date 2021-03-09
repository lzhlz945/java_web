<%--
  Created by IntelliJ IDEA.
  User: 86182
  Date: 2020/12/20
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
这是登录页面。login.jsp 页面 <br>
<form action="http://localhost:8080/filter/loginServlet" method="get">
    <input type="hidden" value="login" name="action">
    用户名：<input type="text" name="username"/> <br>
    密 码：<input type="password" name="password"/> <br>
    <input type="submit" />
</form>
</body>
</html>
