package com.example.Order_Service.controller;

import com.example.Order_Service.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/internal/order")
@RequiredArgsConstructor
public class InternalOrderController {
    private final OrderService orderService;

    //결제 실패로 인한 주문 취소 요청
    @PostMapping("/cancel")
    public ResponseEntity<Void> increase(@RequestParam("id") Long orderId){
        orderService.cancel(orderId);
        return ResponseEntity.ok().build();
    }
}
