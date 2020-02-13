package com.loki.item.core.entity;

import com.loki.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class ItemEntity extends BaseEntity {

    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;

    @Column(name = "unit", nullable = false)
    private String unit;

    @Column(name = "tax_preference", nullable = false)
    private String taxPreference;

    @Column(name = "hsn")
    private String hsn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaxPreference() {
        return taxPreference;
    }

    public void setTaxPreference(String taxPreference) {
        this.taxPreference = taxPreference;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getHsn() {
        return hsn;
    }

    public void setHsn(String hsn) {
        this.hsn = hsn;
    }
}