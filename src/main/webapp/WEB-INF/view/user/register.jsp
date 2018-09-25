<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div>
		<form id="f" action="/user/do_register" method="post">
				<span>用&nbsp;&nbsp;户&nbsp;&nbsp;名</span>
				<input id="txt_username" name="username" type="text" value="${username}"/>
				<span>${usernameMessage}</span><br/>
				<span>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码</span>
				<input id="txt_password" name="password" type="password" value="${password}"/>
				<span>${passwordMessage}</span><br/>
				<span>确认密码</span>
				<input id="txt_password_confirm" type="password" name="password_confirm" value="${password_confirm}"/>
				<span>${passwordMessage}</span><br/>
				<input id="txt_register" type="submit" class="btn btn-primary" value="注册">
		</form>
	</div>
</body>

</html>