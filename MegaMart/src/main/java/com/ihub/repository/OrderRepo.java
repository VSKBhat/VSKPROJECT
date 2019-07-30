package com.ihub.repository;

import org.springframework.data.repository.CrudRepository;

import com.ihub.model.Order;

public interface OrderRepo extends CrudRepository<Order, Integer> {

	
}
