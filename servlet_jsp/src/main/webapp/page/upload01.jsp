<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
    String bathPath=request.getScheme()+"://"+ request.getServerName() +":"+request.getServerPort() + request.getContextPath() + "/";
    request.setAttribute("bathPath",bathPath);
%>
<html>
<head>
    <title>Title</title>
    <base href="<%=bathPath%>">
</head>
<body>
<%--
<form action="uploadServlet" method="post" enctype="multipart/form-data">
    用户名：<input type="text" name="username" /> <br>
    头像：<input type="file" name="photo" > <br>
    <input type="submit" value="上传"> </form>--%>

   <form action="uploadServlet" method="post" enctype="multipart/form-data">
       <input type="text" name="name" value="输入名字" /><br/>
       <input type="file" name="phone" ><br/>
       <input type="submit" value="上传">
   </form>
<hr/>
路径：${bathPath}
</body>
</html>
