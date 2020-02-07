package com.loki.item.dto;

import com.loki.common.dto.BaseDTO;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

public class ItemTypeDTO extends BaseDTO {

    
    @NotNull(message = "name is required")
    @Size(min = 5, max = 32, message = "name length should between 5 to 32")
    @Pattern(regexp = "[A-Za-z0-9]+", message = "item type name should be alphanumeric")
    private String name;
    
    @NotNull(message = "description is required")
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