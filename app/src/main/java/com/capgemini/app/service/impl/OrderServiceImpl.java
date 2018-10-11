package com.capgemini.app.service.impl;

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
		return orderRepository.save(order);
	}
	else
	{
		return null;
	}
	}

	@Override
	public void deleteOrder(int orderId) {
		orderRepository.deleteById(orderId);
		
	}

	@Override
	public Order cancelorder(int orderId) {
		Optional<Order> optional = orderRepository.findById(orderId);
		if (optional.isPresent()) {
			optional.get().setStatus("Cancelled");
			return orderRepository.save(optional.get());
		}
		return null;
	}

	

}
