package com.ReactiveEats.FoodOrderApplication.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.ReactiveEats.FoodOrderApplication.handler.OrderHandler;

@Configuration
public class OrderRouter {
	
	@Bean
	public RouterFunction<ServerResponse> orderRoutes(OrderHandler orderHandler){
		return RouterFunctions.route()
				.POST("/add-order", orderHandler::saveOrder)
				.GET("/get-orders/{userId}", orderHandler::getAllOrdersById)
				.GET("/order/stream",orderHandler::getStreamOfOrders)
				.build();
	}

}
