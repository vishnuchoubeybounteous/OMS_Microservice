package com.vishnu.order_service.dto;


public class OrderRequest {
    private String symbol;
    private Integer quantity;
    private Double price;

    public String getSymbol() { return symbol; }
    public Integer getQuantity() { return quantity; }
    public Double getPrice() { return price; }

    public void setSymbol(String symbol) { this.symbol = symbol; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public void setPrice(Double price) { this.price = price; }
}

