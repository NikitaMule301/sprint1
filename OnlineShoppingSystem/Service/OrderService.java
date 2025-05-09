package com.online.service;
import java.util.List;

import com.online.entity.Order;

//OrderService interface defines CRUD operations for Order entities.

public interface OrderService {
	Order createOrder(Order order);	
	Order getOrder(String orderID);
	List<Order> getAllOrder();
	Order updateOrder(String oId,Order order);
	String deleteOrder(String id);
}
