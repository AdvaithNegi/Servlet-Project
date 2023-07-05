package com.jsp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.Student;

public class StudentDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("advaith");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// Save Record
	public Student saveStudent(Student student) {
		if (student != null) {
			entityTransaction.begin();
			entityManager.persist(student);
			entityTransaction.commit();
			return student;
		} else
			return null;
	}

	// Get By Id Record
	public Student getByIdStudent(int id) {
		return entityManager.find(Student.class, id);
	}
	
	// Get All Record
	public List<Student> getAllStudents(){
		String sql= "select s from Student s";
		Query query=entityManager.createQuery(sql);
		List<Student> students=query.getResultList();
		return students;
	}

}
