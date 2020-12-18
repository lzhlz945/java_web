<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>图书管理</title>
	<%@ include file="/pages/common/head.jsp"%>
<script>
    $(function () {
		$("a.aClass").click(function () {

			if(!confirm("确定删除吗？")){
				return false;
			}

		})
    	$(document).keydown(function (event) {
			if(event.keyCode==13){
				
				fun1();
			}
		})
		$("#qd").click(function () {
          fun1();
		})
    })

	function fun1() {
		var s=$("#pn_input").val();
		window.location.href="${basePath}"+"manager/bookServlet?action=page&pageNo="+s+"&pageSize=4";
	}
</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.jpg" >
			<span class="wel_word">图书管理系统</span>
			<div>
				<a href="book_manager.jsp">图书管理</a>
				<a href="order_manager.jsp">订单管理</a>
				<a href="index.html">返回商城</a>
			</div>
	</div>
	
	<div id="main">
		<table>
			<tr>
				<td>名称</td>
				<td>价格</td>
				<td>作者</td>
				<td>销量</td>
				<td>库存</td>
				<td colspan="2">操作</td>
			</tr>
    <c:forEach items="${requestScope.page.items}" var="book">

			<tr>
				<td>${book.name}</td>
				<td>${book.price}</td>
				<td>${book.author}</td>
				<td>${book.sales}</td>
				<td>${book.stock}</td>
				<td><a href="manager/bookServlet?action=getBook&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>
				<td><a class="aClass" href="manager/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">删除</a></td>
			</tr>
	</c:forEach>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td><a href="pages/manager/book_edit.jsp">添加图书</a></td>
			</tr>	
		</table>
    <div id="page_nav">
        <c:if test="${requestScope.page.pageNo >1}">

        <a href="manager/bookServlet?action=page&pageNo=1&pageSize=4">首页</a>
        <a href="manager/bookServlet?action=page&pageNo=${ requestScope.page.pageNo -1}&pageSize=4">上一页</a>
        </c:if>
        <a href="#">3</a>
        【${ requestScope.page.pageNo }】
        <a href="#">5</a>
        <c:if test="${requestScope.page.pageNo < requestScope.page.pageTotal}">
        <a href="manager/bookServlet?action=page&pageNo=${ requestScope.page.pageNo +1}&pageSize=4">下一页</a>
        <a href="manager/bookServlet?action=page&pageNo=${ requestScope.page.pageTotal }&pageSize=4">末页</a>

        </c:if>
        共${ requestScope.page.pageTotal }页，${ requestScope.page.pageTotalCount }条记录
        到第<input value="${ requestScope.page.pageNo}" name="pn" id="pn_input"/>页
        <input type="button" id="qd" value=" 确定">
    </div>
	</div>

	<%--<%@ include file="/pages/common/footer.jsp"%>--%>

</body>
</html>