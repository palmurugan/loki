package com.loki.item.core.entity;

import com.loki.common.entity.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "itemprice")
public class ItemPriceEntity extends BaseEntity {

    @Column(name = "price", nullable = false)
    private BigDecimal price;
    
    @Column(name = "description")
    private String description;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}