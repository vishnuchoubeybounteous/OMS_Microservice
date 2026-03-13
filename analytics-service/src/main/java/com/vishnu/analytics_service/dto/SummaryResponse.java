package com.vishnu.analytics_service.dto;

public class SummaryResponse {

    private long totalOrders;
    private long createdOrders;
    private long executedOrders;
    private long cancelledOrders;
    private double totalOrderValue;

    public SummaryResponse() {
    }

    public SummaryResponse(long totalOrders,
                           long createdOrders,
                           long executedOrders,
                           long cancelledOrders,
                           double totalOrderValue) {
        this.totalOrders = totalOrders;
        this.createdOrders = createdOrders;
        this.executedOrders = executedOrders;
        this.cancelledOrders = cancelledOrders;
        this.totalOrderValue = totalOrderValue;
    }

    public long getTotalOrders() {
        return totalOrders;
    }

    public long getCreatedOrders() {
        return createdOrders;
    }

    public long getExecutedOrders() {
        return executedOrders;
    }

    public long getCancelledOrders() {
        return cancelledOrders;
    }

    public double getTotalOrderValue() {
        return totalOrderValue;
    }

    public void setTotalOrders(long totalOrders) {
        this.totalOrders = totalOrders;
    }

    public void setCreatedOrders(long createdOrders) {
        this.createdOrders = createdOrders;
    }

    public void setExecutedOrders(long executedOrders) {
        this.executedOrders = executedOrders;
    }

    public void setCancelledOrders(long cancelledOrders) {
        this.cancelledOrders = cancelledOrders;
    }

    public void setTotalOrderValue(double totalOrderValue) {
        this.totalOrderValue = totalOrderValue;
    }
}

