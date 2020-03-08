package com.loki.invoice.dto;

import com.loki.common.dto.BaseDTO;

import javax.persistence.PrePersist;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import java.time.Instant;
import java.util.List;

public class InvoiceDTO extends BaseDTO {

    @NotNull(message = "customerId is required")
    private Long customerId;

    @NotNull(message = "currency is required")
    private String currency;

    @NotNull(message = "invoice date is required")
    private Instant invoiceDate;

    @NotNull(message = "due date is required")
    private Instant dueDate;

    private String notes;

    private Long paymentAttempts;

    private String invoiceStatus;

    private Instant lastRemainder;

    @Valid
    private List<InvoiceLineDTO> invoiceLine;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

    public List<InvoiceLineDTO> getInvoiceLine() {
        return invoiceLine;
    }

    public void setInvoiceLine(List<InvoiceLineDTO> invoiceLine) {
        this.invoiceLine = invoiceLine;
    }
}