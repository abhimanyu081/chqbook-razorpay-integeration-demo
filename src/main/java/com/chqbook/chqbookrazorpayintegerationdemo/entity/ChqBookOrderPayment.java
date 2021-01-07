package com.chqbook.chqbookrazorpayintegerationdemo.entity;


import com.chqbook.chqbookrazorpayintegerationdemo.entity.ChqBookOrder;
import com.chqbook.chqbookrazorpayintegerationdemo.constants.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="payment")
public class ChqBookOrderPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private PaymentStatus paymentStatus;

    @Column(name="amount")
    private Integer amount;

    @JsonIgnore
    @OneToOne(mappedBy = "chqBookOrderPayment")
    private ChqBookOrder chqBookOrder;


    public Long getId() {
        return id;
    }


    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public ChqBookOrder getChqBookOrder() {
        return chqBookOrder;
    }

    public void setChqBookOrder(ChqBookOrder chqBookOrder) {
        this.chqBookOrder = chqBookOrder;
    }


}
