<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%

	String bastPath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<base href="<%=bastPath%>">
<title>阅读人生会员登录页面</title>
	<%-- 静态包含 base标签、css样式、jQuery文件 --%>
	<%@ include file="/pages/common/head.jsp"%>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
	<script type="text/javascript" src="static/jQuery/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function () {
/*
			$("#sub_btn").click(function () {
				$("#spanMsg").html("<%=request.getAttribute("msg")%>");
				if(!"null".eq("<%=request.getAttribute("msg")%>")){
				return false;
				}
			})*/


		})
	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.jpg" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎登录</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>书城会员</h1>
								<a href="pages/user/regist.jsp">立即注册</a>
							</div>
							<div class="msg_cont">
								<b></b>
								<span class="errorMsg" id="spanMsg">"<%--<%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg") %>--%>
								${empty requestScope.msg?"请输入用户名和密码":requestScope.msg}

								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="login" />
									<label>用户名称：</label>
									<input class="itxt" type="text" id="usename" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" id="pas" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<input type="submit" value="登录" id="sub_btn" />
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%@ include file="/pages/common/footer.jsp"%>

</body>
</html>