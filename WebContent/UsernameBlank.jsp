<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="register" method="post">
<h1 style="color:red">You need to enter a username. Try again.</h1>

<h5>Enter a user name for yourself</h5> <input type="text" name="username"/><br>
<h5>Enter a password for yourself</h5> <input type="password" name="password"/><br>
<h5>Re-enter the password </h5><input type="password" name="password2"/>
<input type="submit" value="Submit">
<h4>Already have an account? </h4><a href="Login.jsp">Login here</a><br>
</form>
</body>
</html>