package com.online.Dao;

import java.util.List;

import com.online.entity.Order;

public interface OrderDao {
	Order createOrder(Order order);	//Create a new record of order.
	Order getOrder(String orderID);//Retrieves orders by their unique ID.
	List<Order> getAllOrder();
	Order updateOrder(String oId,Order order);//Updates an existing order record.
	String deleteOrder(String id);//Deletes order record by ID.
}
