package com.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Admin;
import com.jsp.dto.Student;
import com.jsp.service.AdminService;
import com.jsp.service.StudentService;

@WebServlet("/savestudent")
public class SaveStudent extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String aid = req.getParameter("id");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String p1 = req.getParameter("password1");
		String p2 = req.getParameter("password2");

		int id = Integer.parseInt(aid);

		if (p1.equals(p2)) {

			AdminService adminService = new AdminService();
			Admin admin = adminService.getByIdAdmin(id);

			Student student = new Student();
			student.setName(name);
			student.setEmail(email);
			student.setPassword(p1);
			student.setAdmin(admin);

			StudentService studentService = new StudentService();
			studentService.saveStudent(student);
			
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("studentlogin.jsp");
			requestDispatcher.forward(req, resp);
			
		} else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write(
					"<html><head><body><h1>Password Doesn't Match. Check Password Again</h1></body></head></html>");
			printWriter.print("<html><head><body><a href='savestudent.jsp'>Save Student</a></body></head></html>");
		}

	}

}
