package com.chqbook.chqbookrazorpayintegerationdemo.exception;

public class OrderAmountAndPaidAmountMismatched extends RuntimeException {
    public OrderAmountAndPaidAmountMismatched(String message) {
        super(message);
    }

    public OrderAmountAndPaidAmountMismatched(String message, Throwable cause) {
        super(message, cause);
    }
}
