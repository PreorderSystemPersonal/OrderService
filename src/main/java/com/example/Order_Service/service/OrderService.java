package com.example.Order_Service.service;

import com.example.Order_Service.dto.OrderResponseDTO;
import com.example.Order_Service.entity.Order;
import com.example.Order_Service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    //주문 생성하기
    public Long create(String userId, Long productId, Long quantity) {
        Order order = Order.builder()
                .userId(userId)
                .productId(productId)
                .quantity(quantity)
                .build();

        // 레파지토리에 저장
        Order savedorder = orderRepository.save(order);

        //재고 어떻게 할지 고민하기

        return savedorder.getId();
    }

    //주문 조회하기
    public OrderResponseDTO getOrder(Long orderId) {
        return orderRepository.findById(orderId).map(OrderResponseDTO::new).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
    }
    
    //주문 취소하기
    public void cancel(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new IllegalArgumentException("주문 취소가 안되었습니다."));

        order.cancel();
    }

}
