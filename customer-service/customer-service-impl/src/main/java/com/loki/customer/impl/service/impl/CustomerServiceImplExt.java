package com.loki.customer.impl.service.impl;

import com.loki.customer.impl.service.CustomerServiceExt;
import com.loki.customer.impl.repository.CustomerEntityRepositoryExt;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class CustomerServiceImplExt implements CustomerServiceExt {

    private CustomerEntityRepositoryExt repository;

    @Inject
    public CustomerServiceImplExt(CustomerEntityRepositoryExt repository) {
        this.repository = repository;
    }
}