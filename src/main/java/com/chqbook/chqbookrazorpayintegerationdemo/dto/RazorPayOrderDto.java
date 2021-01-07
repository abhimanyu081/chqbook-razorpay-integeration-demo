package com.chqbook.chqbookrazorpayintegerationdemo.dto;

import com.chqbook.chqbookrazorpayintegerationdemo.constants.Currency;
import com.chqbook.chqbookrazorpayintegerationdemo.constants.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

public class RazorPayOrderDto {


    private String id;
    private Integer amount;
    private Currency currency;
    private String receipt;


    private PaymentStatus paymentStatus;


    private Integer attempts;


    private Long createdAt;

    private List<Map<String, Object>> notes=new ArrayList<>();


    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    @JsonIgnore
    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    @JsonProperty("status")
    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @JsonIgnore
    public Integer getAttempts() {
        return attempts;
    }

    @JsonProperty("attempts")
    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    @JsonIgnore
    public Long getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public List<Map<String, Object>> getNotes() {
        return notes;
    }

    public void setNotes(List<Map<String, Object>> notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "RazorPayOrderDto{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", currency=" + currency +
                ", receipt='" + receipt + '\'' +
                ", paymentStatus=" + paymentStatus +
                ", attempts=" + attempts +
                ", createdAt=" + createdAt +
                ", notes=" + notes +
                '}';
    }
}
