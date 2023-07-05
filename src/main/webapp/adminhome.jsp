<%@page import="com.jsp.dto.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.service.StudentService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home Page</title>
</head>
<body>

	<% StudentService studentService = new StudentService(); %>
	<% List<Student> students = studentService.getAllStudents();%>
	

	<table border="1" style="border-collapse: collapse;">
		<tr style="text-align: center;">
			<th><%="Student ID"%></th>
			<th><%="Student Name"%></th>
			<th><%="Student Email"%></th>
			<th><%="Book Name"%></th>
			<th><%="Admin Name"%></th>
		</tr>
		
		<%	for (Student student : students) {	%>
	
		<tr>	
			<td><%= student.getId() %> </td>
			<td><%= student.getName() %> </td>
			<td><%= student.getEmail() %></td>
			<td><%= student.getCourses() %></td>
			<td><%= student.getAdmin().getName() %></td>
		</tr>
			<%	}	%>
	</table>
	
	<br> <br>
	<button><a href="savecourse.jsp">Add Courses</a></button>

	<br> <br>
	<button><a href="home.jsp">Logout</a></button>
	


</body>
</html>