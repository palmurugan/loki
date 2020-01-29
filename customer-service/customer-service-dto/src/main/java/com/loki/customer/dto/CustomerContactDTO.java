package com.loki.customer.dto;

import com.loki.common.dto.BaseDTO;

import javax.validation.constraints.NotNull;

public class CustomerContactDTO extends BaseDTO {

    @NotNull(message = "address1 is required")
    private String address1;

    private String address2;

    @NotNull(message = "city is required")
    private String city;

    @NotNull(message = "state is required")
    private String state;

    @NotNull(message = "country is required")
    private String country;

    @NotNull(message = "zipcode is required")
    private String zip;

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
