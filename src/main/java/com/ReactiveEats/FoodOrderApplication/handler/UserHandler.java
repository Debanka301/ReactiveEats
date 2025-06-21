package com.ReactiveEats.FoodOrderApplication.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.ReactiveEats.FoodOrderApplication.entities.User;
import com.ReactiveEats.FoodOrderApplication.service.UserService;

import reactor.core.publisher.Mono;

@Component
public class UserHandler {
	
	@Autowired
	private UserService userService;
	
	public Mono<ServerResponse> createUser(ServerRequest serverRequest){
		return serverRequest.bodyToMono(User.class)
				.flatMap(userService::saveUser)
				.flatMap(response -> ServerResponse.status(201).bodyValue(response));
	}
	
	

}
