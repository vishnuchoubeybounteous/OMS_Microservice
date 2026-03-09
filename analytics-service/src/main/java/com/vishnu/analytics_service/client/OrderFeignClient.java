package com.vishnu.analytics_service.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "order-service")
public interface OrderFeignClient {

    @GetMapping("/api/orders/admin/all")
    Object getAllOrders(@RequestHeader("Authorization") String authHeader);
}

