package com.loki.configuration.core.entity;

import com.loki.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "listofvaluetype")
public class ListOfValueTypeEntity extends BaseEntity {
    @Column(name = "clientid")
    private Integer clientId;
    
    @Column(name = "name", unique = true)
    private String name;
    
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
    
}