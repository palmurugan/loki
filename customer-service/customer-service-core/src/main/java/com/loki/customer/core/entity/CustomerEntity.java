package com.loki.customer.core.entity;

import com.loki.common.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity {

    @Column(name = "firstname")
    private String firstName;
    
    @Column(name = "lastname")
    private String lastName;
    
    @Column(name = "company")
    private String company;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "phone")
    private String phone;
    
    @Column(name = "type")
    private Integer type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_detail_id")
    private CustomerDetailsEntity customerDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_contact_id")
    private CustomerContactEntity customerContact;

    @OneToOne
    @JoinColumn(name = "customer_group_id")
    private CustomerGroupEntity customerGroup;
    
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

    public CustomerDetailsEntity getCustomerDetail() {
        return customerDetail;
    }

    public void setCustomerDetail(CustomerDetailsEntity customerDetail) {
        this.customerDetail = customerDetail;
    }

    public CustomerGroupEntity getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(CustomerGroupEntity customerGroup) {
        this.customerGroup = customerGroup;
    }

    public CustomerContactEntity getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(CustomerContactEntity customerContact) {
        this.customerContact = customerContact;
    }
}