<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%

	String bastPath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
request.setAttribute("bastPath",bastPath);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>阅读人生会员注册页面</title>
	<base href="<%=bastPath%>">

<link type="text/css" rel="stylesheet" href="static/css/style.css" >
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
	
	h1 a {
		color:red;
	}
</style>
</head>
<body>
		<div id="header">
				<img class="logo_img" alt="" src="static/img/logo.jpg" >
				<div>
					<span>欢迎${sessionScope.user.username}<span class="um_span"></span>光临阅读人生书城</span>
					<a href="../order/order.jsp">我的订单</a>
					<a href="userServlet?action=destroySession">注销</a>&nbsp;&nbsp;
					<a href="index.jsp">返回</a>
				</div>
		</div>
		
		<div id="main">
		
			<h1>欢迎回来 <a href="index.html">转到主页</a></h1>
	
		</div>
		
		<div id="bottom">
			<span>
				阅读人生书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>