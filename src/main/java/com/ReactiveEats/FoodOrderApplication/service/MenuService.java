package com.ReactiveEats.FoodOrderApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReactiveEats.FoodOrderApplication.entities.MenuItem;
import com.ReactiveEats.FoodOrderApplication.repository.MenuRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepository;
	
	public Mono<String> addMenu(MenuItem menuItem){
		return menuRepository.save(menuItem).map(x -> "Menu saved for: "+x.getName());
	}
	
	public Flux<MenuItem> getMenusByCuisine(String cuisine){
		return menuRepository.findByCuisine(cuisine);
	}
	
	

}
