package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Course;
import com.jsp.service.CourseService;

@WebServlet("/savecourse")
public class SaveCourse  extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		
		Course course= new Course();
		course.setName(name);
		
		CourseService courseService= new CourseService();
		courseService.saveCourse(course);
		
		PrintWriter printWriter= resp.getWriter();
		printWriter.write("<html><head><body><h1>Course Saved</h1></body></head></html>");
		printWriter.print("<html><head><body><a href='adminhome.jsp'>Admin Home Page</a></body></head></html>");
		
	}
	

}
