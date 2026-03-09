package com.vishnu.analytics_service.controller;
import com.vishnu.analytics_service.dto.AnalyticsResponse;
import com.vishnu.analytics_service.service.AnalyticsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/summary")
    public AnalyticsResponse summary() {
        return analyticsService.getSummary();
    }
}

