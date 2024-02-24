package com.example.Order_Service.service;

import com.example.Order_Service.client.StockClient;
import com.example.Order_Service.dto.OrderResponseDTO;
import com.example.Order_Service.entity.Order;
import com.example.Order_Service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final StockClient stockClient;

    //주문 생성하기
    @Transactional
    public Long create(String userId, Long productId, Long quantity) {
        Order order = Order.builder()
                .userId(userId)
                .productId(productId)
                .quantity(quantity)
                .build();

        // 레파지토리에 저장
        Order savedorder = orderRepository.save(order);

        //재고 감소 시키기
        stockClient.decrease(productId,quantity);

        return savedorder.getId();
    }

    //주문 조회하기
    @Transactional
    public OrderResponseDTO getOrder(Long orderId) {
        System.out.println("서비스까지 들어옴");
        return orderRepository.findById(orderId).map(OrderResponseDTO::new).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
    }
    
    //주문 취소하기
    @Transactional
    public void cancel(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다."));
        //주문 취소 되었으니 재고 증가
        stockClient.increase(order.getProductId(),order.getQuantity());
        orderRepository.deleteById(orderId);

    }

}
