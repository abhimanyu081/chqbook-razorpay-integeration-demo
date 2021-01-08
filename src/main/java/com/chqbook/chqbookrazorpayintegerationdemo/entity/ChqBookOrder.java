package com.chqbook.chqbookrazorpayintegerationdemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/****
 *
 * @author - Abhimanyu
 *
 * This class represents the order table
 *
 */

@Entity
@Table(name = "orders")
public class ChqBookOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "`user`")
    private String user;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "details")
    private String orderDetails;

    @Column(name = "order_amount")
    private Integer orderAmount;

    @OneToMany(mappedBy = "chqBookOrder")
    private Set<ChqBookOrderPayment> chqBookOrderPaymentSet = new HashSet<>();

    @Column(name = "razorpay_order_id")
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

    public Set<ChqBookOrderPayment> getChqBookOrderPaymentSet() {
        return chqBookOrderPaymentSet;
    }

    public void setChqBookOrderPaymentSet(Set<ChqBookOrderPayment> chqBookOrderPaymentSet) {
        this.chqBookOrderPaymentSet = chqBookOrderPaymentSet;
    }

    public void addPayment(ChqBookOrderPayment chqBookOrderPayment) {

        if (chqBookOrderPaymentSet == null) {
            chqBookOrderPaymentSet = new HashSet<>();
        }
        chqBookOrderPaymentSet.add(chqBookOrderPayment);
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
