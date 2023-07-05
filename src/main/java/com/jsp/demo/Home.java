package com.jsp.demo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class Home extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String al = req.getParameter("adminlogin");
		String sl = req.getParameter("studentlogin");

		if (al != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("adminlogin.jsp");
			requestDispatcher.forward(req, resp);
		} else if (sl != null) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("studentlogin.jsp");
			requestDispatcher.forward(req, resp);
		} else
			return;

	}

}
