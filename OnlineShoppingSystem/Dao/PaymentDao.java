package com.online.Dao;

import java.util.List;

import com.online.entity.Payment;

public interface PaymentDao {
	Payment createPayment(Payment payment);	//Create a new record of payment.
	Payment getPayment(String paymentID);//Retrieves an payments by their unique ID.
	List<Payment> getAllPayments();
	Payment updatePayment(String pId, Payment pay);//Updates an existing payment record.
	String deletePayment(String id);//Deletes payment record by ID.
}
