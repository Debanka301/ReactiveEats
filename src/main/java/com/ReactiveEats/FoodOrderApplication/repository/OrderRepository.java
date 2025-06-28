package com.ReactiveEats.FoodOrderApplication.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.ReactiveEats.FoodOrderApplication.entities.Order;

import reactor.core.publisher.Flux;

@Repository
public interface OrderRepository extends ReactiveMongoRepository<Order, String>{
	
	Flux<Order> findByUserId(String userId);

}
