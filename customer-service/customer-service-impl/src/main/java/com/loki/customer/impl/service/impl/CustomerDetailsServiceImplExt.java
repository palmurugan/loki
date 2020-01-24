package com.loki.customer.impl.service.impl;

import com.loki.customer.impl.service.CustomerDetailsServiceExt;
import com.loki.customer.impl.repository.CustomerDetailsEntityRepositoryExt;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class CustomerDetailsServiceImplExt implements CustomerDetailsServiceExt {

    private CustomerDetailsEntityRepositoryExt repository;

    @Inject
    public CustomerDetailsServiceImplExt(CustomerDetailsEntityRepositoryExt repository) {
        this.repository = repository;
    }
}