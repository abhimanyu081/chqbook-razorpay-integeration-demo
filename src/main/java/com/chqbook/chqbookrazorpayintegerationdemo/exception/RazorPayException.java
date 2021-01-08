package com.chqbook.chqbookrazorpayintegerationdemo.exception;

public class RazorPayException extends RuntimeException{

    public RazorPayException(String message) {
        super(message);
    }

    public RazorPayException(String message, Throwable cause) {
        super(message, cause);
    }
}
