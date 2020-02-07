package com.loki.item.dto;

import com.loki.common.dto.BaseDTO;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

public class ItemPriceDTO extends BaseDTO {

    
    @NotNull(message = "price is required")
    private String price;
    
    @NotNull(message = "description is required")
    private String description;
    
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}