package com.ReactiveEats.FoodOrderApplication.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.ReactiveEats.FoodOrderApplication.entities.User;

import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String>{
	Mono<User> findByEmail(String emailId);
}
