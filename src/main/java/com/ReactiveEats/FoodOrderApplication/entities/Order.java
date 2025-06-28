package com.ReactiveEats.FoodOrderApplication.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    private String id;
    private String emailId;
    private List<String> menuItemId;
    private Instant orderTime;
    private Double price;
    private String status;
    private String userId;// e.g., PLACED, PREPARING, DELIVERED
}

