<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>

	<a href="/user/register">注册</a>
	</br>
	<a href="/user/login">登录</a>
	</br>
	<a href="/user/publish">发帖</a>
	<table border="1px">
		<tr>
			<td>标题</td>
			<td>发帖人</td>
			<td>发帖时间</td>
		</tr>
		<c:forEach items="${bbsPage.list}" var="bbs">
			<tr>
				<td>${bbs.title}</td>
				<td>${bbs.owner}</td>
				<td>${bbs.time}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<c:forEach var="i" begin="1" end="${bbsPage.totalPage}" step="1">
			<c:choose>
			<c:when test="null != ${title} && ${title != ''}">
				<a href="/user/home?title=${title}&pageNum=${i}">${i}</a>&nbsp;
			</c:when>
			<c:otherwise>
				<a href="/user/home?pageNum=${i}">${i}</a>&nbsp;
			</c:otherwise>
			</c:choose>
		</c:forEach>
	</div>

</body>

</html>