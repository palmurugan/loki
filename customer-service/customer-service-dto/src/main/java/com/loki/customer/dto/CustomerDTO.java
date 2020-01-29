package com.loki.customer.dto;

import com.loki.common.dto.BaseDTO;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;

public class CustomerDTO extends BaseDTO {

    
    @NotNull(message = "firstname is required")
    @Size(min = 5, max = 32, message = "firstname length should between 5 to 32")
    @Pattern(regexp = "[A-Za-z0-9]+", message = "customer first name should be alphanumeric")
    private String firstName;
    
    @NotNull(message = "lastname is required")
    private String lastName;
    
    @NotNull(message = "company is required")
    private String company;
    
    @NotNull(message = "email is required")
    private String email;
    
    @NotNull(message = "phone is required")
    private String phone;
    
    private Integer type;

    private CustomerDetailsDTO customerDetail;

    private CustomerGroupDTO customerGroup;

    private CustomerContactDTO customerContact;
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public CustomerDetailsDTO getCustomerDetail() {
        return customerDetail;
    }

    public void setCustomerDetail(CustomerDetailsDTO customerDetail) {
        this.customerDetail = customerDetail;
    }

    public CustomerGroupDTO getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(CustomerGroupDTO customerGroup) {
        this.customerGroup = customerGroup;
    }

    public CustomerContactDTO getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(CustomerContactDTO customerContact) {
        this.customerContact = customerContact;
    }
}