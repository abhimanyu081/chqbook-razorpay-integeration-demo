package com.chqbook.chqbookrazorpayintegerationdemo.service;

import com.chqbook.chqbookrazorpayintegerationdemo.dto.OrderDto;
import com.chqbook.chqbookrazorpayintegerationdemo.entity.ChqBookOrder;

public interface ChqBookOrderService {

    public ChqBookOrder create(OrderDto chqBookOrderDto);
    public ChqBookOrder findById(Long id);

    public ChqBookOrder updatePayment(String razorpayOrderId, String razorpayPaymentId);

    public ChqBookOrder findByRazorPayOrderId(String razorPayOrderId);
}
