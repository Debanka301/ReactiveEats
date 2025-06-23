package com.ReactiveEats.FoodOrderApplication.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MenuItem {
	@Id
	private String id;
	private String name;
	private String cuisine;
	private Double price;

}
