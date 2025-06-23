package com.ReactiveEats.FoodOrderApplication.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.ReactiveEats.FoodOrderApplication.entities.MenuItem;
import com.ReactiveEats.FoodOrderApplication.repository.MenuRepository;
import com.ReactiveEats.FoodOrderApplication.service.MenuService;

import reactor.core.publisher.Flux;

@Controller
public class MenuResolver {
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private MenuRepository menuRepository;
	
	@QueryMapping
	public Flux<MenuItem> getAllMenus(){
		return menuRepository.findAll();
	}
	
	@QueryMapping
	public Flux<MenuItem> getMenusByCuisine(@Argument String cuisine){
		return menuService.getMenusByCuisine(cuisine);
	}

}
