package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Course;
import com.jsp.dto.Student;

public class CourseDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("advaith");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// Save Record
	public Course saveCourse(Course course) {
		if (course != null) {
			entityTransaction.begin();
			entityManager.persist(course);
			entityTransaction.commit();
			return course;
		} else
			return null;
	}

	// Get By Id Record
	public Course getByIdCourse(int id) {
		return entityManager.find(Course.class, id);
	}

	// Get All Records
	public List<Course> getAllCourses() {
		String sql = "select c from Course c";
		Query query = entityManager.createQuery(sql);
		List<Course> courses = query.getResultList();
		return courses;
	}

	// Take Record
	public boolean takeCourse(Student student, List<Course> courses) {

		for (Course course : courses) {
			if (student != null && course != null) {
				entityTransaction.begin();
				entityManager.merge(student);
				entityManager.merge(course);
				entityTransaction.commit();
				System.out.println("Course Taken");
			}
			return true;
		}
		return false;
	}

}
