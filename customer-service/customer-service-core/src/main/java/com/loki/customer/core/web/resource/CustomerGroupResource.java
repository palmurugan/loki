package com.loki.customer.core.web.resource;

import com.loki.common.web.resource.BaseRestResource;
import com.loki.customer.dto.CustomerGroupDTO;
import com.loki.customer.core.service.CustomerGroupService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/customergroup")
public class CustomerGroupResource extends BaseRestResource<CustomerGroupDTO, Long> {

    private CustomerGroupService service;

    @Inject
    public CustomerGroupResource(CustomerGroupService service) {
        super(service, null);
    }
}