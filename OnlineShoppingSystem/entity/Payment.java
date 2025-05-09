package com.online.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity// JPA entity
@Table(name = "Payment_details") // Maps to 'Payments_details' table

public class Payment {
	@Id
	@Column(name = "payment_id", length = 50)//'payment_id' column
	private String payment_id;
	@Column(name = "amount", length = 50)//'name' column with max 50 characters
	private String amount;
	@Column(name = "payment_method", length = 40)//'payment_methiod' column
	private String payment_method;
	@Column(name = "payment_date", length = 50)//'payment_date' column
	private String payment_date;
	@Column(name = "cart", length = 50)//'cart' column
	private String cart;

	// Constructors
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getPayment_method() {
		return payment_method;
	}

	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}

	public String getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(String payment_date) {
		this.payment_date = payment_date;
	}

	public String getCart() {
		return cart;
	}

	public void setCart(String cart) {
		this.cart = cart;
	}

	public Payment(String payment_id, String amount, String payment_method, String payment_date, String cart) {
		super();
		this.payment_id = payment_id;
		this.amount = amount;
		this.payment_method = payment_method;
		this.payment_date = payment_date;
		this.cart = cart;
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", amount=" + amount + ", payment_method=" + payment_method
				+ ", payment_date=" + payment_date + ", cart=" + cart + "]";
	}

}
