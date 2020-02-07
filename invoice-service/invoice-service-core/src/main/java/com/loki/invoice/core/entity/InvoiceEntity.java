package com.loki.invoice.core.entity;

import com.loki.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "invoice")
public class InvoiceEntity extends BaseEntity {
    @Column(name = "invoicedate", unique = true)
    private String invoiceDate;
    
    @Column(name = "description")
    private String description;
    
    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}