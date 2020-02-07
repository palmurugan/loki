package com.loki.invoice.dto;

import com.loki.common.dto.BaseDTO;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

public class InvoiceDTO extends BaseDTO {

    
    @NotNull(message = "invoicedate is required")
    private String invoiceDate;
    
    @NotNull(message = "description is required")
    private String description;
    
    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}