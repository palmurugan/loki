package com.loki.invoice.core.cache.dto;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

public class InvoiceCacheDTO implements Serializable {

    @QuerySqlField(index = true)
    private Long id;

    @QuerySqlField(index = true)
    private Long customerId;

    @NotNull(message = "currency is required")
    @QuerySqlField(index = true)
    private String currency;

    @NotNull(message = "invoice date is required")
    @QuerySqlField(index = true)
    private Instant invoiceDate;

    @NotNull(message = "due date is required")
    @QuerySqlField(index = true)
    private Instant dueDate;

    @QuerySqlField(index = true)
    private String notes;

    @QuerySqlField(index = true)
    private Long paymentAttempts;

    @QuerySqlField(index = true)
    private String invoiceStatus;

    @QuerySqlField(index = true)
    private Instant lastRemainder;

    private BigDecimal total;

    private List<InvoiceLineCacheDTO> invoiceLines;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<InvoiceLineCacheDTO> getInvoiceLines() {
        return invoiceLines;
    }

    public void setInvoiceLines(List<InvoiceLineCacheDTO> invoiceLines) {
        this.invoiceLines = invoiceLines;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
