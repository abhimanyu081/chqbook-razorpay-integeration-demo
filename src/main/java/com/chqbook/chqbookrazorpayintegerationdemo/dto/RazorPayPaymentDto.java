package com.chqbook.chqbookrazorpayintegerationdemo.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "entity",
        "amount",
        "currency",
        "status",
        "order_id",
        "invoice_id",
        "international",
        "method",
        "amount_refunded",
        "refund_status",
        "captured",
        "description",
        "card_id",
        "bank",
        "wallet",
        "vpa",
        "email",
        "contact",
        "customer_id",
        "notes",
        "fee",
        "tax",
        "error_code",
        "error_description",
        "error_source",
        "error_step",
        "error_reason",
        "acquirer_data",
        "created_at"
})
public class RazorPayPaymentDto {

    @JsonProperty("id")
    private String id;
    @JsonProperty("entity")
    private String entity;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("status")
    private String status;
    @JsonProperty("order_id")
    private String orderId;
    @JsonProperty("invoice_id")
    private String invoiceId;
    @JsonProperty("international")
    private Boolean international;
    @JsonProperty("method")
    private String method;
    @JsonProperty("amount_refunded")
    private Integer amountRefunded;
    @JsonProperty("refund_status")
    private String refundStatus;
    @JsonProperty("captured")
    private Boolean captured;
    @JsonProperty("description")
    private String description;
    @JsonProperty("card_id")
    private String cardId;
    @JsonProperty("bank")
    private String bank;
    @JsonProperty("wallet")
    private String wallet;
    @JsonProperty("vpa")
    private String vpa;
    @JsonProperty("email")
    private String email;
    @JsonProperty("contact")
    private String contact;
    @JsonProperty("customer_id")
    private String customerId;

    @JsonProperty("fee")
    private Integer fee;
    @JsonProperty("tax")
    private Integer tax;
    @JsonProperty("error_code")
    private String errorCode;
    @JsonProperty("error_description")
    private String errorDescription;
    @JsonProperty("error_source")
    private String errorSource;
    @JsonProperty("error_step")
    private String errorStep;
    @JsonProperty("error_reason")
    private String errorReason;;
    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("entity")
    public String getEntity() {
        return entity;
    }

    @JsonProperty("entity")
    public void setEntity(String entity) {
        this.entity = entity;
    }

    @JsonProperty("amount")
    public Integer getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("order_id")
    public String getOrderId() {
        return orderId;
    }

    @JsonProperty("order_id")
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @JsonProperty("invoice_id")
    public String getInvoiceId() {
        return invoiceId;
    }

    @JsonProperty("invoice_id")
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    @JsonProperty("international")
    public Boolean getInternational() {
        return international;
    }

    @JsonProperty("international")
    public void setInternational(Boolean international) {
        this.international = international;
    }

    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    @JsonProperty("amount_refunded")
    public Integer getAmountRefunded() {
        return amountRefunded;
    }

    @JsonProperty("amount_refunded")
    public void setAmountRefunded(Integer amountRefunded) {
        this.amountRefunded = amountRefunded;
    }

    @JsonProperty("refund_status")
    public String getRefundStatus() {
        return refundStatus;
    }

    @JsonProperty("refund_status")
    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    @JsonProperty("captured")
    public Boolean getCaptured() {
        return captured;
    }

    @JsonProperty("captured")
    public void setCaptured(Boolean captured) {
        this.captured = captured;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("card_id")
    public String getCardId() {
        return cardId;
    }

    @JsonProperty("card_id")
    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @JsonProperty("bank")
    public String getBank() {
        return bank;
    }

    @JsonProperty("bank")
    public void setBank(String bank) {
        this.bank = bank;
    }

    @JsonProperty("wallet")
    public String getWallet() {
        return wallet;
    }

    @JsonProperty("wallet")
    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    @JsonProperty("vpa")
    public String getVpa() {
        return vpa;
    }

    @JsonProperty("vpa")
    public void setVpa(String vpa) {
        this.vpa = vpa;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("contact")
    public String getContact() {
        return contact;
    }

    @JsonProperty("contact")
    public void setContact(String contact) {
        this.contact = contact;
    }

    @JsonProperty("customer_id")
    public String getCustomerId() {
        return customerId;
    }

    @JsonProperty("customer_id")
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @JsonProperty("fee")
    public Integer getFee() {
        return fee;
    }

    @JsonProperty("fee")
    public void setFee(Integer fee) {
        this.fee = fee;
    }

    @JsonProperty("tax")
    public Integer getTax() {
        return tax;
    }

    @JsonProperty("tax")
    public void setTax(Integer tax) {
        this.tax = tax;
    }

    @JsonProperty("error_code")
    public String getErrorCode() {
        return errorCode;
    }

    @JsonProperty("error_code")
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @JsonProperty("error_description")
    public String getErrorDescription() {
        return errorDescription;
    }

    @JsonProperty("error_description")
    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    @JsonProperty("error_source")
    public String getErrorSource() {
        return errorSource;
    }

    @JsonProperty("error_source")
    public void setErrorSource(String errorSource) {
        this.errorSource = errorSource;
    }

    @JsonProperty("error_step")
    public String getErrorStep() {
        return errorStep;
    }

    @JsonProperty("error_step")
    public void setErrorStep(String errorStep) {
        this.errorStep = errorStep;
    }

    @JsonProperty("error_reason")
    public String getErrorReason() {
        return errorReason;
    }

    @JsonProperty("error_reason")
    public void setErrorReason(String errorReason) {
        this.errorReason = errorReason;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
