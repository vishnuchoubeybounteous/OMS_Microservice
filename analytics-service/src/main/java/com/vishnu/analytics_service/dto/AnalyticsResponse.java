package com.vishnu.analytics_service.dto;



import java.util.Map;

public class AnalyticsResponse {

    private String message;
    private Map<String, Long> ordersByUser;

    public AnalyticsResponse() {
    }

    public AnalyticsResponse(String message, Map<String, Long> ordersByUser) {
        this.message = message;
        this.ordersByUser = ordersByUser;
    }

    public String getMessage() {
        return message;
    }

    public Map<String, Long> getOrdersByUser() {
        return ordersByUser;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setOrdersByUser(Map<String, Long> ordersByUser) {
        this.ordersByUser = ordersByUser;
    }
}

