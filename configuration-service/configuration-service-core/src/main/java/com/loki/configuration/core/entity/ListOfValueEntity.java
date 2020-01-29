package com.loki.configuration.core.entity;

import com.loki.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "listofvalue")
public class ListOfValueEntity extends BaseEntity {
    @Column(name = "code")
    private String code;
    
    @Column(name = "description")
    private String description;
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}