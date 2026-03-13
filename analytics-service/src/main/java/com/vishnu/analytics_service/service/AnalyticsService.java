package com.vishnu.analytics_service.service;

import com.vishnu.analytics_service.client.OrderFeignClient;
import com.vishnu.analytics_service.dto.AnalyticsResponse;
import com.vishnu.analytics_service.dto.OrderDto;
import com.vishnu.analytics_service.dto.SummaryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AnalyticsService {

    private final OrderFeignClient orderFeignClient;

    public AnalyticsService(OrderFeignClient orderFeignClient) {
        this.orderFeignClient = orderFeignClient;
    }

    public SummaryResponse getSummary(String authHeader) {
        List<OrderDto> orders = orderFeignClient.getAllOrders(authHeader);

        long totalOrders = orders.size();
        long createdOrders = orders.stream()
                .filter(o -> "CREATED".equalsIgnoreCase(o.getStatus()))
                .count();

        long executedOrders = orders.stream()
                .filter(o -> "EXECUTED".equalsIgnoreCase(o.getStatus()))
                .count();

        long cancelledOrders = orders.stream()
                .filter(o -> "CANCELLED".equalsIgnoreCase(o.getStatus()))
                .count();

        double totalOrderValue = orders.stream()
                .mapToDouble(o -> {
                    double price = o.getPrice() == null ? 0.0 : o.getPrice();
                    int quantity = o.getQuantity() == null ? 0 : o.getQuantity();
                    return price * quantity;
                })
                .sum();

        return new SummaryResponse(
                totalOrders,
                createdOrders,
                executedOrders,
                cancelledOrders,
                totalOrderValue
        );
    }

    public AnalyticsResponse getOrdersGroupedByUser(String authHeader) {
        List<OrderDto> orders = orderFeignClient.getAllOrders(authHeader);

        Map<String, Long> grouped = orders.stream()
                .collect(Collectors.groupingBy(
                        OrderDto::getCreatedBy,
                        Collectors.counting()
                ));

        return new AnalyticsResponse("Orders grouped by user fetched successfully", grouped);
    }

    public List<OrderDto> getAllOrdersForAnalytics(String authHeader) {
        return orderFeignClient.getAllOrders(authHeader);
    }
}
