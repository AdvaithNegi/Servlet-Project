<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Login Page</title>
</head>
<body>

	<a href="home.jsp">Home Page</a>
	<br> <br>

	<form action="studentlogin" method="post">
	
		ID: <input type="number" name="id" placeholder="Enter your ID"> <br> <br>
		Password: <input type="password" name="password" placeholder="Enter your Password"> <br> <br>
		<input type="submit" value="Login">
		
	</form>
	
	<br> <br>
	<a href="savestudent.jsp">SignUp Student</a>

</body>
</html>