package com.loki.configuration.dto;

import com.loki.common.dto.BaseDTO;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

public class ListOfValueDTO extends BaseDTO {

    
    @NotNull(message = "code is required")
    @Size(min = 2, max = 12, message = "code length should between 2 to 12")
    @Pattern(regexp = "[A-Za-z0-9]+", message = "code should be alphanumeric")
    private String code;
    
    @NotNull(message = "description is required")
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