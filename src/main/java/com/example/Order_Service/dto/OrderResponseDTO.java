package com.example.Order_Service.dto;

import com.example.Order_Service.entity.Order;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class OrderResponseDTO {
    @JsonFormat
    private Long orderId;
    @JsonFormat
    private Long productId;
    @JsonFormat
    private String userId;

    @JsonFormat
    private Long quantity;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deletedAt;

    public OrderResponseDTO(Order entity){
        this.orderId = entity.getId();
        this.productId = entity.getProductId();
        this.userId = entity.getUserId();
        this.quantity = entity.getQuantity();
        this.createdAt = entity.getCreatedAt();
    }
}
