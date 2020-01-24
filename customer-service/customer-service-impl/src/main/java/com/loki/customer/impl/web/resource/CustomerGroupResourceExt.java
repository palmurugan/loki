package com.loki.customer.impl.web.resource;

import com.loki.customer.impl.service.CustomerGroupServiceExt;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class CustomerGroupResourceExt {

    private CustomerGroupServiceExt service;

    @Inject
    public CustomerGroupResourceExt(CustomerGroupServiceExt service) {
        this.service = service;
    }
}