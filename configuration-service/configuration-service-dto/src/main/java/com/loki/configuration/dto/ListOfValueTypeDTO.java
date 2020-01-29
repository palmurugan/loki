package com.loki.configuration.dto;

import com.loki.common.dto.BaseDTO;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

public class ListOfValueTypeDTO extends BaseDTO {

    
    private Integer clientId;
    
    @NotNull(message = "name is required")
    @Size(min = 3, max = 32, message = "name length should between 3 to 32")
    @Pattern(regexp = "[A-Za-z0-9]+", message = "Lov type name should be alphanumeric")
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