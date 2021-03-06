package com.loki.item.core.entity;

import com.loki.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "item_type")
public class ItemTypeEntity extends BaseEntity {

    @Column(name = "name", unique = true)
    private String name;
    
    @Column(name = "description")
    private String description;
    
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