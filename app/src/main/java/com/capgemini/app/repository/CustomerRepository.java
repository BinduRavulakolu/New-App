package com.capgemini.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.capgemini.app.entities.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	
	
	

}
