package com.online.Dao;

import java.util.List;

import com.online.entity.Admin;

public interface AdminDao {
	Admin createAdmin(Admin admin);	
	Admin getAdmin(String adminID); //Retrieves an Admin by their unique ID.
	List<Admin> getAllAdmin();
	Admin updateAdmin(String aId, Admin admin);//Updates an existing Admin record.
	String deleteAdmin(String id);//Deletes an Admin record by ID.
}
