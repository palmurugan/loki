package com.loki.customer.impl.web.resource;

import com.loki.customer.impl.service.CustomerDetailsServiceExt;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class CustomerDetailsResourceExt {

    private CustomerDetailsServiceExt service;

    @Inject
    public CustomerDetailsResourceExt(CustomerDetailsServiceExt service) {
        this.service = service;
    }
}