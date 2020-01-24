package com.loki.customer.core.entity;

import com.loki.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "customer_group")
public class CustomerGroupEntity extends BaseEntity {

    @Column(name = "client_id")
    private Integer clientId;
    
    @Column(name = "name", unique = true)
    private String name;
    
    @Column(name = "type")
    private Integer type;
    
    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    
}