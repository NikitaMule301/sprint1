package com.online.service;

import java.util.List;

import com.online.entity.Admin;
public interface AdminService {
	Admin createAdmin(Admin admin);	
	Admin getAdmin(String adminID);
	List<Admin> getAllAdmin();
	Admin updateAdmin(String aId, Admin admin);
	String deleteAdmin(String id);
}
