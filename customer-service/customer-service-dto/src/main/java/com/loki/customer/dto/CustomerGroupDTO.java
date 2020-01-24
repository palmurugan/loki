package com.loki.customer.dto;

import com.loki.common.dto.BaseDTO;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

public class CustomerGroupDTO extends BaseDTO {

    
    private Integer clientId;
    
    @NotNull(message = "name is required")
    @Size(min = 5, max = 32, message = "name length should between 5 to 32")
    @Pattern(regexp = "[A-Za-z0-9]+", message = "Group name should be alphanumeric")
    private String name;
    
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