package com.vishnu.order_service.entity;



import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String symbol;
    private Integer quantity;
    private Double price;
    private String createdBy;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public Long getId() { return id; }
    public String getSymbol() { return symbol; }
    public Integer getQuantity() { return quantity; }
    public Double getPrice() { return price; }
    public String getCreatedBy() { return createdBy; }
    public OrderStatus getStatus() { return status; }

    public void setId(Long id) { this.id = id; }
    public void setSymbol(String symbol) { this.symbol = symbol; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public void setPrice(Double price) { this.price = price; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }
    public void setStatus(OrderStatus status) { this.status = status; }
}

