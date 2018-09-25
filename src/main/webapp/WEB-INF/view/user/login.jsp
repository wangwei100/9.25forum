<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form id="f" action="/user/do_login" method="post">
			<span> 用户名:</span> <input id="txt_username" name="username" type="text" value="${username}" /> <span>${usernameMessage}</span> <br />
			<div />

			<span>密码:</span> <input id="txt_password" name="password" type="password" value="${password}" /> <span>${passwordMessage}</span> <br />
			<div />

			<input id="txt_login" class="btn btn-primary" type="submit" value="登陆" />
		</form>
	</div>
</body>
</html>