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
import com.jsp.service.AdminService;

@WebServlet("/saveadmin")
public class SaveAdmin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String p1 = req.getParameter("password1");
		String p2 = req.getParameter("password2");

		if (p1.equals(p2)) {
			Admin admin = new Admin();
			AdminService adminService = new AdminService();
			admin.setName(name);
			admin.setPassword(p1);
			adminService.saveAdmin(admin);

			RequestDispatcher requestDispatcher = req.getRequestDispatcher("adminlogin.jsp");
			requestDispatcher.forward(req, resp);
		} else {
			PrintWriter printWriter = resp.getWriter();
			printWriter.write(
					"<html><head><body><h1>Password Doesn't Match. Check Password Again</h1></body></head></html>");
			printWriter.print("<html><head><body><a href='saveadmin.jsp'>Save Admin</a></body></head></html>");
		}

	}

}
