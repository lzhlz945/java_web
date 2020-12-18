<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

	String bastPath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>阅读人生会员注册页面</title>
	<base href="<%=bastPath%>">
	<!--写 base 标签，永远固定相对路径跳转的结果-->
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
				<span class="wel_word"></span>
				<div>
					<span>欢迎<span class="um_span">韩总</span>光临阅读人生书城</span>
					<a href="order/order.html">我的订单</a>
					<a href="index.html">注销</a>&nbsp;&nbsp;
					<a href="index.html">返回</a>
				</div>
		</div>
		
		<div id="main">
		
			<h1>注册成功! <a href="index.html">转到主页</a></h1>
	
		</div>
		
		<div id="bottom">
			<span>
				阅读人生书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>