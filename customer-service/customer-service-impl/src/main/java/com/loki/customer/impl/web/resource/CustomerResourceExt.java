package com.loki.customer.impl.web.resource;

import com.loki.customer.impl.service.CustomerServiceExt;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class CustomerResourceExt {

    private CustomerServiceExt service;

    @Inject
    public CustomerResourceExt(CustomerServiceExt service) {
        this.service = service;
    }
}