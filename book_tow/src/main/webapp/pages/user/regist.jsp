<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<!--写 base 标签，永远固定相对路径跳转的结果-->

<title>阅读人生会员注册页面</title>
	<%@ include file="/pages/common/head.jsp"%>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
	<script type="text/javascript" src="static/jQuery/jquery-1.7.2.js"></script>
	<script type="text/javascript">
		$(function () {
			$("#code_img").click(function () {
				this.src="${bathPath}kaptcha.jpg?d="+new Date();

			})
			//用户名失去焦点
			$("#username").blur(function () {
				alert(123)
			   $.ajax({
				   url:"${bathPath}userServlet",
				   data:{
			   	    "action":"checkUserName",
					"username":$("#username").val()
				},
				   type:"GET",
				   dataType:"json",
				   success:function (data) {
				   	if(data.mesg){
						$(".errorMsg").html("用户已存在！");
                          return;
					}else {
						$(".errorMsg").html("可以注册该用户名");
					}
				   }



			   })
			})

			//绑定注册按钮
			$("#sub_btn").click(function () {

			//1.验证用户名
			var userName=$("#username").val();
			var username=/^\w{5,12}$/;
			if(!username.test(userName)){
				$(".errorMsg").html("用户名格式不对！");
				return false;
			}

			//2、验证密码
				var password=$("#password").val();
			    var passwordCheck=/^\w{5,12}$/;
			    if(!passwordCheck.test(password)){
			    	$(".errorMsg").text("密码格式不对！")
					return false;
				}

			//3、验证第二次输入的密码
				var checkPassword=$("#repwd").val();
			    if(checkPassword != password){
					$(".errorMsg").text("两次输入的密码不一致！")
					return false;
				}
			// 邮箱验证：xxxxx@xxx.com //1 获取邮箱里的内容
			var emailText = $("#email").val();
			//2 创建正则表达式对象
			 var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
			 //3 使用 test 方法验证是否合法
			if (!emailPatt.test(emailText)) {
				$("span.errorMsg").text("邮箱格式不合法！");
				 return false;
			}

			//验证验证码
			var code=$.trim($("#code").val());
			if(code==null || code==""){
				$("span.errorMsg").text("验证码错误，有空格");
				return false;
			}

			$("span.errorMsg").text("");
			})



		})


	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.jpg" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册阅读人生会员</h1>
								<span class="errorMsg"></span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" value="${requestScope.username}" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" value="${requestScope.email}" autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<%--<label>验证码：</label>
									<input class="itxt" type="text" style="width: 100px;" id="code" name="code"/>
									<img alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px">--%>
									<label>验证码：</label>
									<input class="itxt" type="text" name="code" style="width: 80px;" id="code" />
									<img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px; width: 110px; height: 30px;">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
			<span>
				阅读人生书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>