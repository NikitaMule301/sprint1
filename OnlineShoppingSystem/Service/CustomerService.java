package com.online.service;
import java.util.List;

import com.online.entity.Customer;
//CustomerService interface defines CRUD operations for Customer entities.

public interface CustomerService {
	Customer createCustomer(Customer customer);	
	Customer getCustomer(String customerID);
	List<Customer> getAllCustomer();
	Customer updateCustomer(String cId, Customer customer);
	String deleteCustomer(String id);
}
