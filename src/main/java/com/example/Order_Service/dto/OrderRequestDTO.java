package com.example.Order_Service.dto;

import com.example.Order_Service.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {
    private Long productId;
    private Long quantity;
}
