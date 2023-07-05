package com.jsp.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Student;
import com.jsp.service.StudentService;

@WebServlet("/studentlogin")
public class StudentLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String sid = req.getParameter("id");
		String password = req.getParameter("password");

		int id = Integer.parseInt(sid);
		
		StudentService studentService=new StudentService();
		Student student=studentService.getByIdStudent(id);
		
		if(id==student.getId()&&password.equals(student.getPassword())) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("studenthome.jsp");
			requestDispatcher.forward(req, resp);
		}
		else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("studentlogin.jsp");
			requestDispatcher.include(req, resp);
		}
	}

}
