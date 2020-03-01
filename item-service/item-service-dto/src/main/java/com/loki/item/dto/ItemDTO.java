package com.loki.item.dto;

import com.loki.common.dto.BaseDTO;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

public class ItemDTO extends BaseDTO {

    
    @NotNull(message = "name is required")
    @Size(min = 2, max = 12, message = "name length should between 2 to 12")
    @Pattern(regexp = "[A-Za-z0-9]+", message = "item should be alphanumeric")
    private String name;
    
    @NotNull(message = "description is required")
    private String description;

    @NotNull(message = "unit is required")
    private String unit;

    @NotNull(message = "tax preference is required")
    private String taxPreference;

    private String hsn;

    @NotNull(message = "Price is required")
    private BigDecimal price;

    private ItemCategoryDTO itemCategory;
    
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTaxPreference() {
        return taxPreference;
    }

    public void setTaxPreference(String taxPreference) {
        this.taxPreference = taxPreference;
    }

    public String getHsn() {
        return hsn;
    }

    public void setHsn(String hsn) {
        this.hsn = hsn;
    }

    public ItemCategoryDTO getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(ItemCategoryDTO itemCategory) {
        this.itemCategory = itemCategory;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}