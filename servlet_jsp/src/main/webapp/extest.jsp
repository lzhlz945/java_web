<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
      request.setAttribute("key", "request");
      session.setAttribute("key", "session");
      application.setAttribute("key", "application");
      pageContext.setAttribute("key", "pageContext");
  %>

    ${ key }
<div align="center">

</div>
</body>
</html>
