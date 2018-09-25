<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form id="f" action="/user/do_publish" method="post">
			<span>标题</span> 
			<input id="#txt_title" name="title" type="text" value="${title}" /> 
			<span>${titleMessage}</span> 
			</br> 
			<span>内容</span> 
			<input id="#txt_content" name="content" type="text" value="${content}"> 
			<span>${contentMessage}</span> 
			</br> 
			<input id="#txt_publish" type="submit" class="btn btn-primary" value="发表">
		</form>
	</div>
</body>
</html>