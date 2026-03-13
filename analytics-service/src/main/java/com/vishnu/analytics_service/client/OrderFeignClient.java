package com.vishnu.analytics_service.client;


import com.vishnu.analytics_service.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "order-service")
public interface OrderFeignClient {

    @GetMapping("/api/orders/admin/all")
    List<OrderDto> getAllOrders(@RequestHeader("Authorization") String authHeader);
}

