package com.loki.customer.core.web.resource;

import com.loki.common.web.resource.BaseRestResource;
import com.loki.customer.core.web.validator.CustomerValidator;
import com.loki.customer.dto.CustomerDTO;
import com.loki.customer.core.service.CustomerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource extends BaseRestResource<CustomerDTO, Long> {

    private CustomerService customerService;

    private CustomerValidator customerValidator;

    @Inject
    public CustomerResource(CustomerService customerService, CustomerValidator customerValidator) {
        super(customerService, customerValidator);
    }
}