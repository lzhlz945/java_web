<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%@ include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			$("a.aaa").click(function () {

				if(!confirm("确定删除此商品吗？")){
					return false;
				}

			})

			$("#clearCart").click(function () { return confirm("你确定要清空购物车吗?"); })

			$("input.updateCount").change(function () {
				// 获取商品名称
				 var name = $(this).parent().parent().find("td:first").text();
				 var id = $(this).attr('bookId');
				 // 获取商品数量
				 var count = this.value;
				if(count<=0){
					location.href = "${bathPath}items?action=deleteItems&id="+id;
				}
				 if ( confirm("你确定要将【" + name + "】商品修改数量为：" + count + " 吗?") )
				 {

				 	//发起请求。给服务器保存修改
					 location.href = "${bathPath}items?action=updateCount&count="+count+"&id="+id;
				 }
				 else {
				 	// defaultValue 属性是表单项 Dom 对象的属性。它表示默认的 value 属性值。
					 this.value = this.defaultValue;
				 }
			})
		})

	</script>
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
				<td>
					<input class="updateCount" style="width: 80px;"
						   bookId="${entry.value.id}"
						   type="text" value="${entry.value.count}">
				</td>
				<td>${entry.value.price}</td>
				<td>${entry.value.totalPrice}</td>
				<td><a class="aaa" href="items?action=deleteItems&id=${entry.value.id}">删除</a></td>
			</tr>
			</c:forEach>
			</c:if>

			
		</table>
	<c:if test="${not empty sessionScope.cart.items}">

		<div class="cart_info">
			<span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount()}</span>件商品</span>
			<span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice()}</span>元</span>
			<span class="cart_span"><a id="clearCart" href="items?action=clearItems">清空购物车</a></span>
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