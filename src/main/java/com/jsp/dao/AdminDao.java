package com.jsp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jsp.dto.Admin;

public class AdminDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("advaith");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// Save Record
	public Admin saveAdmin(Admin admin) {
		if (admin != null) {
			entityTransaction.begin();
			entityManager.persist(admin);
			entityTransaction.commit();
			return admin;
		} else
			return null;
	}

	// Get By Id Record
	public Admin getByIdAdmin(int id) {
		return entityManager.find(Admin.class, id);
	}
}
