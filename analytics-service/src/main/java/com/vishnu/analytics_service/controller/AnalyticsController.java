package com.vishnu.analytics_service.controller;
import com.vishnu.analytics_service.dto.AnalyticsResponse;
import com.vishnu.analytics_service.dto.OrderDto;
import com.vishnu.analytics_service.dto.SummaryResponse;
import com.vishnu.analytics_service.service.AnalyticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




import java.util.List;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/summary")
    public SummaryResponse getSummary(@RequestHeader("Authorization") String authHeader) {
        return analyticsService.getSummary(authHeader);
    }

    @GetMapping("/orders-by-user")
    public AnalyticsResponse getOrdersByUser(@RequestHeader("Authorization") String authHeader) {
        return analyticsService.getOrdersGroupedByUser(authHeader);
    }

    @GetMapping("/orders")
    public List<OrderDto> getOrders(@RequestHeader("Authorization") String authHeader) {
        return analyticsService.getAllOrdersForAnalytics(authHeader);
    }
}


