package com.jsp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.dto.Course;
import com.jsp.dto.Student;
import com.jsp.service.CourseService;
import com.jsp.service.StudentService;

@WebServlet("/takecourse")
public class TakeCourse extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String s_id = req.getParameter("sid");
		String c_id = req.getParameter("cid");

		int sid = Integer.parseInt(s_id);
		int cid = Integer.parseInt(c_id);

		StudentService studentService = new StudentService();
		Student student = studentService.getByIdStudent(sid);

		CourseService courseService = new CourseService();
		List<Course> courses = courseService.getAllCourses();

		for (Course course : courses) {
			if (course.getId() == cid) {
				Course course2 = courseService.getByIdCourse(cid);
				course2.setStudent(student);

				List<Course> courses2 = new ArrayList<>();
				courses2.add(course2);

				boolean flag = courseService.takeCourse(student, courses2);

				if (flag == true) {
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("studenthome.jsp");
					requestDispatcher.forward(req, resp);
				} else {
					RequestDispatcher requestDispatcher = req.getRequestDispatcher("takecourse.jsp");
					requestDispatcher.include(req, resp);
				}
			}
		}

	}

}
