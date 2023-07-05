<%@page import="com.jsp.dto.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.jsp.service.CourseService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Home Page</title>
</head>
<body>
	
	<% CourseService courseService= new CourseService(); %>
	<% List<Course> courses=courseService.getAllCourses(); %>

	<table border="1" style="border-collapse: collapse;">
		
		<tr style="text-align: center;">
			<th><%="ID"%></th>
			<th><%="Course Name"%></th>
			<th><%="Actions"%></th>
		</tr>
		
		<% for(Course course:courses) {%>
		<tr>
			<td><%= course.getId() %> </td>
			<td><%= course.getName() %> </td>
			<td><a href="takecourse.jsp">Take Course</a></td>
		</tr>
			
			<% } %>
</table>

<br> <br>
<button><a href="home.jsp">Logout</a></button>
	
</body>
</html>