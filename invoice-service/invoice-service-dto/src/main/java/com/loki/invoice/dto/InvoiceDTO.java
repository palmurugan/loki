package com.loki.invoice.dto;

import com.loki.common.dto.BaseDTO;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import java.time.Instant;

public class InvoiceDTO extends BaseDTO {

    private Long customerId;

    private Long currencyId;

    private Instant invoiceDate;

    private Instant dueDate;

    private String notes;

    private Long paymentAttempts;

    private String invoiceStatus;

    private Instant lastRemainder;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Long currencyId) {
        this.currencyId = currencyId;
    }

    public Instant getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Instant invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Instant getDueDate() {
        return dueDate;
    }

    public void setDueDate(Instant dueDate) {
        this.dueDate = dueDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getPaymentAttempts() {
        return paymentAttempts;
    }

    public void setPaymentAttempts(Long paymentAttempts) {
        this.paymentAttempts = paymentAttempts;
    }

    public String getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(String invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public Instant getLastRemainder() {
        return lastRemainder;
    }

    public void setLastRemainder(Instant lastRemainder) {
        this.lastRemainder = lastRemainder;
    }
}