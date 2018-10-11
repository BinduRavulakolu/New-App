package com.capgemini.app.service;

import java.util.List;

import com.capgemini.app.entities.Order;

public interface OrderService{
	
	public Order submitOrder(Order order);
	public Order getOrder(int orderId);
	public List<Order> getOrders();
	public Order updateOrder(Order order);
	public Order deleteOrder(int orderId);
	public Order cancelorder(int orderId,String status);
	

}
