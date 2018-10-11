package com.capgemini.app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.app.entities.Order;
import com.capgemini.app.repository.OrderRepository;
import com.capgemini.app.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public Order submitOrder(Order order) {
//		Optional<Order> optional=orderRepository.findById(order.getCustomerId());
		
			return orderRepository.save(order);
		
	}

	@Override
	public Order getOrder(int orderId) {
		Optional<Order> order=orderRepository.findById(orderId);
		return order.get();
	}

	@Override
	public Order updateOrder(Order order) {
	Optional<Order> optional=orderRepository.findById(order.getOrderId());
	if(optional.isPresent())
	{
		optional.get().setStatus("updated");
		return orderRepository.save(optional.get());
	}
	else
	{
		return null;
	}
	}

	@Override
	public Order deleteOrder(int orderId) {
		
		Optional<Order> optional = orderRepository.findById(orderId);
		if (optional.isPresent()) {
			optional.get().setStatus("Deleted");
//			return orderRepository.save(optional.get());
			return optional.get();
		}
		return null;
	}

	@Override
	public Order cancelorder(int orderId, String status) {
		Optional<Order> optional = orderRepository.findById(orderId);
		if (optional.isPresent()) {
			optional.get().setStatus(status);
//			return orderRepository.save(optional.get());
			return optional.get();
		}
		return null;
	}

	@Override
	public List<Order> getOrders() {
		
		return orderRepository.findAll();
	}

	
	

}
