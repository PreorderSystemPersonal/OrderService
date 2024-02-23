package com.example.Order_Service.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "Order_table")
@Getter
@Setter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //주문 정보 ID
    private Long id;

    // 상품 정보 ID
    @Column
    private Long productId;

    //주문한 회원 정보 ID
    @Column
    private String userId;

    //각 상품 정보 수량
    @Column
    private Long quantity;

//    //총금액
//    @Column
//    private Long total;

    //주문한 시각
    @Column
    @CreatedDate
    private LocalDateTime createdAt;

    //주문 취소 시각
    @Column
    private LocalDateTime deletedAt;

    @Builder
    public Order(String userId, Long productId,Long quantity){
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public void cancel() {
        this.deletedAt = LocalDateTime.now();
    }
}
