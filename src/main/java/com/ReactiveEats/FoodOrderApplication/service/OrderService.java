package com.ReactiveEats.FoodOrderApplication.service;

import java.time.Instant;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.ReactiveEats.FoodOrderApplication.entities.Order;
import com.ReactiveEats.FoodOrderApplication.entities.OrderRequestDTO;
import com.ReactiveEats.FoodOrderApplication.entities.User;
import com.ReactiveEats.FoodOrderApplication.repository.MenuRepository;
import com.ReactiveEats.FoodOrderApplication.repository.OrderRepository;
import com.ReactiveEats.FoodOrderApplication.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	private WebClient webClient = WebClient.create();
	
	private Sinks.Many<Order> orderSink = Sinks.many().multicast().onBackpressureBuffer();
	
	public Mono<String> saveOrder(OrderRequestDTO order) throws InterruptedException, ExecutionException {
		
//		User user = webClient.get().uri("http://localhost:8080/get-by-email/"+order.getEmailId())
//							.retrieve().bodyToMono(User.class).toFuture().get();
		
		User user = userRepository.findByEmail(order.getEmailId()).toFuture().get();
		
		Double totalPrice = order.getMenuItemIds().stream().map(x ->{
			try {
				Double price = menuRepository.findById(x).toFuture().get().getPrice();
				return price;
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			return null;
		}).toList().stream().reduce((double) 0,(a,b) -> a+b);
		
		Order saveOrder = new Order();
		saveOrder.setMenuItemId(order.getMenuItemIds());
		saveOrder.setOrderTime(Instant.now());
		saveOrder.setPrice(totalPrice);
		saveOrder.setStatus("placed");
		saveOrder.setEmailId(order.getEmailId());
		saveOrder.setUserId(user.getId());
		
		return orderRepository.save(saveOrder).flatMap(x->{
			orderSink.tryEmitNext(x);
			return Mono.just("Order saved for : "+x.getEmailId());
		});
		
    }
	
	public Flux<Order> streamNewOrders(){
		return orderSink.asFlux();
	}

    public Flux<Order> getOrdersByUser(String userId) {
        return orderRepository.findByUserId(userId);
    }

    public Mono<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

}
