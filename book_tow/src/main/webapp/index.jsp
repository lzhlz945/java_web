<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%--只负责请求转发--%>
<jsp:forward page="/manager/bookServlet?action=indexPage"></jsp:forward>
<%@ include file="pages/common/head.jsp"%>
<script>
    /*$(function () {
       window.location.href="${bathPath}"+"manager/bookServlet?action=indexPage";
    })*/
</script>