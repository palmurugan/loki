package com.loki.customer.dto;

import com.loki.common.dto.BaseDTO;

import javax.validation.constraints.NotNull;

public class CustomerDetailsDTO extends BaseDTO {


    @NotNull(message = "taxpreference is required")
    private String taxPreference;

    @NotNull(message = "currency is required")
    private String currency;

    private String tin;

    private String gstin;

    private String pan;

    @NotNull(message = "credit limit is required")
    private Double creditLimit;

    @NotNull(message = "bill credit limit is required")
    private Double billCreditLimit;

    @NotNull(message = "payment terms is required")
    private String paymentTerms;

    @NotNull(message = "bill type is required")
    private String billType;

    @NotNull(message = "billing period is required")
    private String billingPeriod;

    public String getTaxPreference() {
        return taxPreference;
    }

    public void setTaxPreference(String taxPreference) {
        this.taxPreference = taxPreference;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTin() {
        return tin;
    }

    public void setTin(String tin) {
        this.tin = tin;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Double getBillCreditLimit() {
        return billCreditLimit;
    }

    public void setBillCreditLimit(Double billCreditLimit) {
        this.billCreditLimit = billCreditLimit;
    }

    public String getPaymentTerms() {
        return paymentTerms;
    }

    public void setPaymentTerms(String paymentTerms) {
        this.paymentTerms = paymentTerms;
    }

    public String getBillingPeriod() {
        return billingPeriod;
    }

    public void setBillingPeriod(String billingPeriod) {
        this.billingPeriod = billingPeriod;
    }

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }
}