package com.capgemini.app.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.app.entities.Item;
import com.capgemini.app.entities.Order;
import com.capgemini.app.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	private HashMap<Integer, Set<Item>> hashMap;

	public OrderController() {
		hashMap = new HashMap<>();
	}

	@PostMapping("/cart/{customerId}")
	public ResponseEntity<Set<Item>> addCart(@RequestBody Item item, @PathVariable int customerId) {
		Set<Item> sampleItems = hashMap.get(customerId);
		if (sampleItems == null) {
			sampleItems = new HashSet<Item>();
			sampleItems.add(item);
			hashMap.put(customerId, sampleItems);
		} else {
			sampleItems.add(item);
			hashMap.put(customerId, sampleItems);
		}

		return new ResponseEntity<Set<Item>>(sampleItems, HttpStatus.OK);
	}

	/*
	 * @PostMapping("/order/{customerId}") public ResponseEntity<Order>
	 * placeOrder(@RequestBody Order order,@PathVariable int customerId) {
	 * List<Item> sampleItems=(List<Item>) hashMap.get(order.getCustomerId()); Order
	 * order1=new Order(); order1.setCustomerId(order.getCustomerId());
	 * order1.setDate(LocalDate.now()); order1.setItems(sampleItems);
	 * order1.setTotal(0); return new
	 * ResponseEntity<Order>(orderService.submitOrder(order),HttpStatus.OK); }
	 */
	
	
	@PostMapping("/order")
	public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
		ResponseEntity<Order> responseEntity = new ResponseEntity<Order>(orderService.submitOrder(order),
				HttpStatus.OK);
		return responseEntity;
	}

	@GetMapping("/order/{orderId}")
	public ResponseEntity<Order> cancelOrder(@PathVariable int orderId) {
		ResponseEntity<Order> responseEntity = new ResponseEntity<Order>(orderService.cancelorder(orderId),HttpStatus.OK);
		return responseEntity;
	}
	
	@PutMapping("/order1")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
	   ResponseEntity<Order> responseEntity=  new ResponseEntity<>(orderService.updateOrder(order), HttpStatus.OK);
	   return responseEntity;
	}
	
	
	
}
