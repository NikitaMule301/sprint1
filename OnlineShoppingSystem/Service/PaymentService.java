package com.online.service;
import java.util.List;

import com.online.entity.Payment;
//PaymentService interface defines CRUD operations for payment entities.

public interface PaymentService {
	Payment createPayment(Payment payment);	
	Payment getPayment(String paymentID);
	List<Payment> getAllPayments();
	Payment updatePayment(String pId, Payment pay);
	String deletePayment(String id);
}
