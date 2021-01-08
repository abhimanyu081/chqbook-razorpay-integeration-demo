package com.chqbook.chqbookrazorpayintegerationdemo.service.razorpay;

import com.chqbook.chqbookrazorpayintegerationdemo.dto.OrderDto;

public interface RazorPayOrderService {

    public OrderDto create(OrderDto razorPayOrderDto);

}
