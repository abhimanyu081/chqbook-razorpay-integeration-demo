package com.chqbook.chqbookrazorpayintegerationdemo.service.razorpay;

import com.chqbook.chqbookrazorpayintegerationdemo.dto.RazorPayPaymentDto;

public interface RazorPayPaymentService {

    public RazorPayPaymentDto fetchPaymentById(String paymentId);


}
