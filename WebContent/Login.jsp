<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css">    

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Login</h1>
	<form action="login" method="post">
		<h2>
			User name <input type="text" name="username" id="usernameIn"/>
		</h2>
		<br>
		<h2>
			Password <input type="password" name="password"/>
		</h2>
		<input type="submit" value="Login"><br>
		<br> New User?
		<a href="Register.jsp">Register here</a><br>
	</form>
	
</body>
</html>