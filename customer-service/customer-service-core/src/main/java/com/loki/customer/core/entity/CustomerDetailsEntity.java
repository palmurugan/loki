package com.loki.customer.core.entity;

import com.loki.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "customer_details")
public class CustomerDetailsEntity extends BaseEntity {

    @Column(name = "tax_preference")
    private String taxPreference;
    
    @Column(name = "currency")
    private String currency;
    
    @Column(name = "tin")
    private String tin;
    
    @Column(name = "gstin")
    private String gstin;
    
    @Column(name = "pan")
    private String pan;
    
    @Column(name = "credit_limit")
    private Double creditLimit;
    
    @Column(name = "bill_credit_limit")
    private Double billCreditLimit;
    
    @Column(name = "payment_terms")
    private String paymentTerms;
    
    @Column(name = "bill_type")
    private String billType;

    @Column(name = "billing_period")
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

    public String getBillType() {
        return billType;
    }

    public void setBillType(String billType) {
        this.billType = billType;
    }

    public String getBillingPeriod() {
        return billingPeriod;
    }

    public void setBillingPeriod(String billingPeriod) {
        this.billingPeriod = billingPeriod;
    }
}