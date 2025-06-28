package com.ReactiveEats.FoodOrderApplication.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {
	
	private String emailId;
    private List<String> menuItemIds;

}
