package com.loki.expense.core.entity;

import com.loki.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "expensetype")
public class ExpenseTypeEntity extends BaseEntity {
    @Column(name = "clientid", unique = true)
    private Long clientId;
    
    @Column(name = "name", unique = true)
    private String name;
    
    @Column(name = "description")
    private String description;
    
    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    
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
    
}