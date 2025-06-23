package com.ReactiveEats.FoodOrderApplication.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.ReactiveEats.FoodOrderApplication.entities.MenuItem;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface MenuRepository extends ReactiveMongoRepository<MenuItem, String>{
	
	Flux<MenuItem> findByCuisine(String cuisine);

}
