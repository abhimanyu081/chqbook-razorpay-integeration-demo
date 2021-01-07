package com.chqbook.chqbookrazorpayintegerationdemo.service;

import com.chqbook.chqbookrazorpayintegerationdemo.entity.ChqBookOrderPayment;

public interface ChqBookOrderPaymentService {


    public ChqBookOrderPayment create(ChqBookOrderPayment chqBookOrderPayment);
    public ChqBookOrderPayment findById(Long id);
}
