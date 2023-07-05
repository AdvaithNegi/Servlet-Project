package com.jsp.service;

import java.util.List;

import com.jsp.dao.CourseDao;
import com.jsp.dto.Course;
import com.jsp.dto.Student;

public class CourseService {

	CourseDao courseDao = new CourseDao();

	// Save Course
	public Course saveCourse(Course course) {
		return courseDao.saveCourse(course);
	}

	// Get By Id Course
	public Course getByIdCourse(int id) {
		return courseDao.getByIdCourse(id);
	}

	// Get All Courses
	public List<Course> getAllCourses() {
		return courseDao.getAllCourses();
	}

	// Take Course
	public boolean takeCourse(Student student, List<Course> courses) {
		return courseDao.takeCourse(student, courses);
	}

}
