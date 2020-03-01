package com.loki.invoice.core.entity;

import com.loki.common.entity.BaseEntity;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "invoice")
public class InvoiceEntity extends BaseEntity {

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "currency_id")
    private Long currencyId;

    @Column(name = "invoice_date")
    private Instant invoiceDate;

    @Column(name = "due_date")
    private Instant dueDate;

    @Column(name = "notes")
    private String notes;

    @Column(name = "payment_attempts")
    private Long paymentAttempts;

    @Column(name = "invoice_status")
    private String invoiceStatus;

    @Column(name = "last_remainder")
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