package com.loki.configuration.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.loki.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "listofvalue")
public class ListOfValueEntity extends BaseEntity {

    @Column(name = "code")
    private String code;
    
    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn
    private ListOfValueTypeEntity listOfValueType;
    
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

    public ListOfValueTypeEntity getListOfValueType() {
        return listOfValueType;
    }

    public void setListOfValueType(ListOfValueTypeEntity listOfValueType) {
        this.listOfValueType = listOfValueType;
    }
}