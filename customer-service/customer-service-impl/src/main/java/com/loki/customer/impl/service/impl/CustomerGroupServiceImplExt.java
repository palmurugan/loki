package com.loki.customer.impl.service.impl;

import com.loki.customer.impl.service.CustomerGroupServiceExt;
import com.loki.customer.impl.repository.CustomerGroupEntityRepositoryExt;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class CustomerGroupServiceImplExt implements CustomerGroupServiceExt {

    private CustomerGroupEntityRepositoryExt repository;

    @Inject
    public CustomerGroupServiceImplExt(CustomerGroupEntityRepositoryExt repository) {
        this.repository = repository;
    }
}