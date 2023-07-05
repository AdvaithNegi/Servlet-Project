<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save Student</title>
</head>
<body>

	<form action="savestudent" method="post">
	
		ID: <input type="number" name="id" placeholder="Enter your Admin ID"> <br> <br>
		Name: <input type="text" name="name" placeholder="Enter your Name"> <br> <br>
		Email: <input type="email" name="email" placeholder="Enter your Email"> <br> <br>
		Password1: <input type="password" name="password1" placeholder="Set your Password"> <br> <br>
		Password2: <input type="password" name="password2" placeholder="Repeat your Password"> <br> <br>
		<input type="submit" value="Save Student">
	
	</form>

</body>
</html>