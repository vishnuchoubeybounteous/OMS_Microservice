package com.vishnu.order_service.service;


import com.vishnu.order_service.dto.OrderRequest;
import com.vishnu.order_service.entity.Order;
import com.vishnu.order_service.entity.OrderStatus;
import com.vishnu.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(OrderRequest request, String username) {
        Order order = new Order();
        order.setSymbol(request.getSymbol());
        order.setQuantity(request.getQuantity());
        order.setPrice(request.getPrice());
        order.setCreatedBy(username);
        order.setStatus(OrderStatus.CREATED);
        return orderRepository.save(order);
    }

    public List<Order> getOrdersByUser(String username) {
        return orderRepository.findByCreatedBy(username);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order cancelOrder(Long id) {
        Order order = orderRepository.findById(id).orElseThrow();
        order.setStatus(OrderStatus.CANCELLED);
        return orderRepository.save(order);
    }
}

