package com.loki.item.dto;

import com.loki.common.dto.BaseDTO;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

public class ItemCategoryDTO extends BaseDTO {

    
    @NotNull(message = "name is required")
    @Size(min = 2, max = 12, message = "name length should between 2 to 12")
    @Pattern(regexp = "[A-Za-z0-9]+", message = "category should be alphanumeric")
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