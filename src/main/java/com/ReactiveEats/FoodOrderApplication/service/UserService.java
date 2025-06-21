package com.ReactiveEats.FoodOrderApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import com.ReactiveEats.FoodOrderApplication.entities.User;
import com.ReactiveEats.FoodOrderApplication.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public Mono<String> saveUser(User user){
		return userRepository.save(user).flatMap(UserService::saveUserMessage);
	}
	
	public Mono<User> getUserByEmail(ServerRequest serverRequest){
		return userRepository.findByEmail(serverRequest.pathVariable("emailId"));
	}
	
	public Flux<User> getAllUsers(){
		return userRepository.findAll();
	}
	public static Mono<String> saveUserMessage(User user){
		return Mono.just("User Saved for name :"+user.getName());
	}

	public Mono<User> getUserGraphQlByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
