<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%@include file="/pages/common/head.jsp"%>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.jpg" >
			<span class="wel_word">购物车</span>
			<div>
				<span>欢迎<span class="um_span">x总</span>光临天天看书书城</span>
				<a href="pages/order/order.html">我的订单</a>
				<a href="userServlet?action=destroySession">注销</a>&nbsp;&nbsp;
				<a href="index.jsp">返回</a>
			</div>
	</div>
	
	<div id="main">
	
		<table>
			<tr>
				<td>商品名称</td>
				<td>数量</td>
				<td>单价</td>
				<td>金额</td>
				<td>操作</td>
			</tr>
			<c:if test="${ empty sessionScope.cart.items}">
				<tr>
					<td colspan="5"><a href="index.jsp">空空如也，点击浏览商品！</a></td>

			</c:if>
			<c:if test="${not empty sessionScope.cart.items}">
			<c:forEach items="${sessionScope.cart.items}" var="entry">
			<tr>
				<td>${entry.value.name}</td>
				<td>${entry.value.count}</td>
				<td>${entry.value.price}</td>
				<td>${entry.value.totalPrice}</td>
				<td><a href="#">删除</a></td>
			</tr>
			</c:forEach>
			</c:if>

			
		</table>
	<c:if test="${not empty sessionScope.cart.items}">

		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">4</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">90.00</span>元</span>
			<span class="cart_span"><a href="#">清空购物车</a></span>
			<span class="cart_span"><a href="pages/cart/checkout.html">去结账</a></span>
		</div>
	</c:if>


	</div>
	
	<div id="bottom">
		<span>
			天天看书书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>