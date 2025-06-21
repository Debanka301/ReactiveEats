package com.ReactiveEats.FoodOrderApplication.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.ReactiveEats.FoodOrderApplication.entities.User;
import com.ReactiveEats.FoodOrderApplication.service.UserService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class UserResolver {
	
	@Autowired
	private UserService userService;
	
	@QueryMapping
	public Flux<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@QueryMapping
	public Mono<User> getUserByEmail(@Argument String email){
		return userService.getUserGraphQlByEmail(email);
	}

}
