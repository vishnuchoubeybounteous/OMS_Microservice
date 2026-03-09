package com.vishnu.analytics_service.service;



import com.vishnu.analytics_service.dto.AnalyticsResponse;
import org.springframework.stereotype.Service;

@Service
public class AnalyticsService {
    public AnalyticsResponse getSummary() {
        return new AnalyticsResponse("Analytics summary generated successfully");
    }
}

