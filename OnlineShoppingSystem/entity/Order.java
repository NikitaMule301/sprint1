package com.online.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity// JPA entity
@Table(name = "Order_details") // Maps to 'Order_details' table

public class Order {
	@Id
	@Column(name = "order_id", length = 50)//'order_id' column
	private String order_id;
	@Column(name = "location", length = 50)//'name' column with max 50 characters
	private String location;
	@Column(name = "order_date", length = 50)//'order_date' column
	private String orderDate;
	@Column(name = "total", length = 50)//'total' column
	private String total;

	// Constructors
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public Order(String order_id, String location, String orderDate, String total) {
		super();
		this.order_id = order_id;
		this.location = location;
		this.orderDate = orderDate;
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", location=" + location + ", orderDate=" + orderDate + ", total="
				+ total + "]";
	}

}
