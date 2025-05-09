package com.online.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity// JPA entity
@Table(name = "Customer_details") // Maps to 'Customer_details' table
public class Customer {
	@Id

	@Column(name = "customer_id", length = 50)//'customer_id' column
	private String customer_id;
	@Column(name = "Name", length = 50)//'name' column with max 50 characters
	private String Name;
	@Column(name = "email", length = 50)//'email' column
	private String email;
	@Column(name = "mobileNumber", length = 50)
	private String mobileNumber;
	@Column(name = "password", length = 50)// 'password' column
	private String password;
	@Column(name = "Address", length = 50)//address column with max 50 characters
	private String Address;

	// Constructors
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
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

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Customer(String customer_id, String name, String email, String mobileNumber, String password,
			String address) {
		super();
		this.customer_id = customer_id;
		Name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.password = password;
		Address = address;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", Name=" + Name + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", password=" + password + ", Address=" + Address + "]";
	}

}