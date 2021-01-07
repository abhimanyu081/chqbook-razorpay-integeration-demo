package com.chqbook.chqbookrazorpayintegerationdemo.entity;

import com.chqbook.chqbookrazorpayintegerationdemo.constants.OrderStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class ChqBookOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user")
    private String user;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "details")
    private String orderDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private ChqBookOrderPayment chqBookOrderPayment;

    @Column(name="razorpay_order_id")
    private String razorPayOrderId;

    public String getRazorPayOrderId() {
        return razorPayOrderId;
    }

    public void setRazorPayOrderId(String razorPayOrderId) {
        this.razorPayOrderId = razorPayOrderId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @JsonIgnore
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @JsonIgnore
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public ChqBookOrderPayment getChqBookOrderPayment() {
        return chqBookOrderPayment;
    }

    public void setChqBookOrderPayment(ChqBookOrderPayment chqBookOrderPayment) {
        this.chqBookOrderPayment = chqBookOrderPayment;
    }
}
