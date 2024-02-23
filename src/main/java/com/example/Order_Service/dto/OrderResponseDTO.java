package com.example.Order_Service.dto;

import com.example.Order_Service.entity.Order;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class OrderResponseDTO {
    private Long orderId;

    private Long productId;

    private String userId;

    private Long quantity;

    private LocalDateTime createdAt;

    private LocalDateTime deletedAt;

    public OrderResponseDTO(Order entity){
        this.orderId = entity.getId();
        this.productId = entity.getProductId();
        this.userId = entity.getUserId();
        this.quantity = entity.getQuantity();
        this.createdAt = entity.getCreatedAt();
    }
}
