package com.ReactiveEats.FoodOrderApplication.handler;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.ReactiveEats.FoodOrderApplication.entities.Order;
import com.ReactiveEats.FoodOrderApplication.entities.OrderRequestDTO;
import com.ReactiveEats.FoodOrderApplication.service.OrderService;

import reactor.core.publisher.Mono;

@Component
public class OrderHandler {
	
	@Autowired
	private OrderService orderService;
	
	public Mono<ServerResponse> saveOrder(ServerRequest serverRequest){
		return serverRequest.bodyToMono(OrderRequestDTO.class).flatMap(x -> {
			try {
				return orderService.saveOrder(x);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			return null;
		}).flatMap(x -> ServerResponse.status(201).bodyValue(x));
	}
	
	public Mono<ServerResponse> getAllOrdersById(ServerRequest serverRequest){
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(orderService.getOrdersByUser(serverRequest.pathVariable("userId")),Order.class);
	}
	
	public Mono<ServerResponse> getStreamOfOrders(ServerRequest serverRequest){
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(orderService.streamNewOrders(),Order.class);
	}

}
