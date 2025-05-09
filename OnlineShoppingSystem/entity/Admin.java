package com.online.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity// JPA entity
@Table(name = "admin_details") // Maps to 'admin_details' table
public class Admin {
	@Id
	@Column(name = "Admin_id", length = 50)//'admin_id' column
	private String Admin_id;
	@Column(name = "Name", length = 50)//'admin_name' column
	private String Name;
	@Column(name = "email", length = 50)// 'email' column
	private String email;
	@Column(name = "mobileNumber", length = 50)//'mobileNumber column'
	private String mobileNumber;
	@Column(name = "password", length = 50)//'password' column
	private String password;

	// Constructors
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAdmin_id() {
		return Admin_id;
	}

	public void setAdmin_id(String admin_id) {
		Admin_id = admin_id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin(String admin_id, String name, String email, String mobileNumber, String password) {
		super();
		Admin_id = admin_id;
		Name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [Admin_id=" + Admin_id + ", Name=" + Name + ", email=" + email + ", mobileNumber=" + mobileNumber
				+ ", password=" + password + "]";
	}

}
