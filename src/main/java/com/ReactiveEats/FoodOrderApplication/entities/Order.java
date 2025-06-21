package com.ReactiveEats.FoodOrderApplication.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    private String id;
    private String userId;
    private String menuItemId;
    private LocalDateTime orderTime;
    private String status; // e.g., PLACED, PREPARING, DELIVERED
}

