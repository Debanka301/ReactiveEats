package com.ReactiveEats.FoodOrderApplication.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.ReactiveEats.FoodOrderApplication.handler.UserHandler;

@Configuration
public class UserRouter {
	
	@Bean
	public RouterFunction<ServerResponse> userRoutes(UserHandler userHandler){
		return RouterFunctions.route()
				.POST("/save-user",userHandler::createUser)
				.GET("/get-by-email/{emailId}", userHandler::getUserByEmail)
				.build();
	}

}
