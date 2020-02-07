package com.loki.invoice.core.entity;

import com.loki.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "invoiceline")
public class InvoiceLineEntity extends BaseEntity {
    @Column(name = "price")
    private String price;
    
    @Column(name = "description")
    private String description;
    
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}