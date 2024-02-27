package com.example.Order_Service.controller;

import com.example.Order_Service.dto.OrderRequestDTO;
import com.example.Order_Service.dto.OrderResponseDTO;
import com.example.Order_Service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/OrderService")
public class OrderController {
    private final OrderService orderService;

//    주문 등록하기
    @PostMapping("/order/new")
    public ResponseEntity<String> create(@RequestHeader("X-USER-ID") String userId, @Valid @RequestBody OrderRequestDTO order){
        Long orderId = orderService.create(userId, order.getProductId(),order.getQuantity());

        return ResponseEntity.ok().body("주문이 생성되었습니다. "+orderId);
    }


    //주문 조회하기
    @GetMapping("/order/{orderId}")
    public OrderResponseDTO getOrder(@PathVariable(name="orderId") Long orderId){
        System.out.println(orderId);
        return orderService.getOrder(orderId);
    }


    //주문 취소하기
    @DeleteMapping("/order/{id}")
    public ResponseEntity<Void> cancel(@PathVariable(name="id") Long orderId){
        orderService.cancel(orderId);
        return ResponseEntity.ok().build();
    }
}
