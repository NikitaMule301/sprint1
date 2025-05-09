package com.online.Dao;

import java.util.List;

import com.online.entity.Customer;

public interface CustomerDao {
	Customer createCustomer(Customer customer);//Create a new record of customer.
	Customer getCustomer(String customerID); //Retrieves an customer by their unique ID.
	List<Customer> getAllCustomer();
	Customer updateCustomer(String cId, Customer customer);//Updates an existing customer record.
	String deleteCustomer(String id);//Deletes customer record by ID.
}
