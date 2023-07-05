package com.jsp.service;

import java.util.List;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class StudentService {

	StudentDao studentDao = new StudentDao();

	// Save Student
	public Student saveStudent(Student student) {
		return studentDao.saveStudent(student);
	}

	// Get By Id Student
	public Student getByIdStudent(int id) {
		return studentDao.getByIdStudent(id);
	}

	// Get All Students
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

}
