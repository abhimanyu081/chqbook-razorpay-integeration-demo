package com.chqbook.chqbookrazorpayintegerationdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/***
 * @author - Abhimanyu
 * This class represents request json from the chqbook order creation frontend
 * Later this dto is converted into DB entity and saved
 * The same dto is fired to Razorpay servers to create a razorpay api
 *
 */
public class OrderDto {

    /*****
     * Below fields are according to Razorpay
     * order create API request
     *
     */
    private Integer amount;
    private String currency;
    private String receipt;
    private Integer paymentCapture;

    /***
     * below fields are specific to chqbook
     * transactionId : this should be generated be some other services before initiating the transaction
     * and then it should be send in the order creation API, so that duplicate orders/payments can be checked.
     */

    private String transactionId;

    /****
     *
     *   orderDetails - to keep things simple I have used a String filed
     *     else I should have used a List to capture Line Items
     */
    private String orderDetails;

    /***
     * This id is returned from razorpay API
     * and set after API call
     */
    private String razorPayOrderId;

    @JsonIgnore
    public String getRazorPayOrderId() {
        return razorPayOrderId;
    }

    @JsonProperty("id")
    public void setRazorPayOrderId(String razorPayOrderId) {
        this.razorPayOrderId = razorPayOrderId;
    }

    public Integer getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getReceipt() {
        return receipt;
    }

    @JsonProperty("receipt")
    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public Integer getPaymentCapture() {
        return paymentCapture;
    }

    @JsonProperty("payment_capture")
    public void setPaymentCapture(Integer paymentCapture) {
        this.paymentCapture = paymentCapture;
    }

    @JsonIgnore
    public String getTransactionId() {
        return transactionId;
    }

    @JsonProperty("transaction_id")
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @JsonIgnore
    public String getOrderDetails() {
        return orderDetails;
    }

    @JsonProperty("order_details")
    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }
}
