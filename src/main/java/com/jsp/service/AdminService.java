package com.jsp.service;

import com.jsp.dao.AdminDao;
import com.jsp.dto.Admin;

public class AdminService {

	AdminDao adminDao = new AdminDao();

	// Save Admin
	public Admin saveAdmin(Admin admin) {
		return adminDao.saveAdmin(admin);
	}

	// Get By Id Admin
	public Admin getByIdAdmin(int id) {
		return adminDao.getByIdAdmin(id);
	}

}
