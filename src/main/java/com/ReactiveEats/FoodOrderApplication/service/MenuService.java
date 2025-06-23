package com.ReactiveEats.FoodOrderApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ReactiveEats.FoodOrderApplication.entities.MenuItem;
import com.ReactiveEats.FoodOrderApplication.repository.MenuRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepository;
	
	private Sinks.Many<MenuItem> menuSink = Sinks.many().multicast().onBackpressureBuffer();
	
	public Mono<String> addMenu(MenuItem menuItem){
		return menuRepository.save(menuItem).flatMap(x ->{
			menuSink.tryEmitNext(x);
			return Mono.just("Menu saved for : "+x.getName());
		});
	}
	
	public Flux<MenuItem> getMenusByCuisine(String cuisine){
		return menuRepository.findByCuisine(cuisine);
	}
	
	public Flux<MenuItem> streamNewMenuItems(){
		return menuSink.asFlux();
	}
	
	

}
