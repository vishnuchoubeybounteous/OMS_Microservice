package com.vishnu.order_service.controller;

import com.vishnu.order_service.dto.OrderRequest;

import com.vishnu.order_service.entity.Order;
import com.vishnu.order_service.service.OrderService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/trader/create")
    public Order create(@RequestBody OrderRequest request, Authentication authentication) {
        return orderService.createOrder(request, authentication.getName());
    }

    @GetMapping("/trader/my")
    public List<Order> myOrders(Authentication authentication) {
        return orderService.getOrdersByUser(authentication.getName());
    }

    @GetMapping("/admin/all")
    public List<Order> allOrders() {
        return orderService.getAllOrders();
    }

    @PutMapping("/admin/cancel/{id}")
    public Order cancel(@PathVariable("id") Long id) {
        return orderService.cancelOrder(id);
    }
}

