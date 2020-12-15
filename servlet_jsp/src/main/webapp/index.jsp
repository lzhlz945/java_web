<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
  <%ServletContext servletContext=request.getServletContext();
    String qj=(String) servletContext.getAttribute("qj");
    String ss=(String) servletContext.getAttribute("ss");
  %>
  <div>第一个监听器的值：<%=qj%></div>
  <div>第二个监听器的值：<%=ss%></div>
</body>
</html>
