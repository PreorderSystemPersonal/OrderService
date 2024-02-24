package com.example.Order_Service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;


@FeignClient(name="stockClient",url="${feign.stockClient.url}")
public interface StockClient {

    //주문 생성시 재고량 감소
    @RequestMapping(method= RequestMethod.POST, value="/api/internal/stock/decrease", consumes = "application/json")
    void decrease(@RequestParam(name = "id") Long productId, @RequestParam(name = "stock") Long stock);

    //주문 취소시 재고량 증가
    @RequestMapping(method= RequestMethod.POST, value = "/api/internal/stock/increase",consumes = "application/json")
    void increase(@RequestParam(name = "id") Long productId, @RequestParam(name="stock") Long stock);

    //주문 할때 재고 조회
    @RequestMapping(method = RequestMethod.GET, value = "/api/internal/stock/{id}")
    void get(@PathVariable(name="id")Long productId);
}

