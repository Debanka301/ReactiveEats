package com.ReactiveEats.FoodOrderApplication.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.ReactiveEats.FoodOrderApplication.entities.MenuItem;
import com.ReactiveEats.FoodOrderApplication.service.MenuService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class MenuHandler {
	
	@Autowired
	private MenuService menuService;
	
	public Mono<ServerResponse> saveMenu(ServerRequest serverRequest){
		return serverRequest.bodyToMono(MenuItem.class)
				.flatMap(x -> menuService.addMenu(x))
				.flatMap(x -> ServerResponse.status(201).bodyValue(x));
	}
	
	public Mono<ServerResponse> getMenuByCuisine(ServerRequest serverRequest){
		Flux<MenuItem> menusByCuisine = menuService.getMenusByCuisine(serverRequest.pathVariable("cuisine"));
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(menusByCuisine,MenuItem.class);
	}
	
	public Mono<ServerResponse> streamMenu(ServerRequest serverRequest){
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(menuService.streamNewMenuItems(),MenuItem.class);
	}

}
