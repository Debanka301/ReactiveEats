package com.ReactiveEats.FoodOrderApplication.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.ReactiveEats.FoodOrderApplication.handler.MenuHandler;

@Configuration
public class MenuRouter {
	
	
	@Bean
	public RouterFunction<ServerResponse> menuRoutes(MenuHandler menuHandler){
		return RouterFunctions.route()
				.POST("/add-menu", menuHandler::saveMenu)
				.GET("/get-by-cuisine/{cuisine}", menuHandler::getMenuByCuisine)
				.build();
	}

}
