package com.vishnu.analytics_service.dto;


public class AnalyticsResponse {
    private String message;

    public AnalyticsResponse() {}
    public AnalyticsResponse(String message) { this.message = message; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
