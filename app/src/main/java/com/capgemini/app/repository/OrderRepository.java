package com.capgemini.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.app.entities.Order;

public interface OrderRepository extends MongoRepository<Order, Integer> {
	
	

}
