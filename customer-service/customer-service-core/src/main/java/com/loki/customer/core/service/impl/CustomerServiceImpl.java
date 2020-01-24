package com.loki.customer.core.service.impl;

import com.loki.common.service.impl.GenericService;
import com.loki.customer.core.entity.CustomerEntity;
import com.loki.customer.dto.CustomerDTO;
import com.loki.customer.core.mapper.CustomerMapper;
import com.loki.customer.core.repository.CustomerEntityRepository;
import com.loki.customer.core.service.CustomerService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl extends GenericService<CustomerDTO, CustomerEntity, Long> implements CustomerService {

    private CustomerEntityRepository repository;

    private CustomerMapper mapper;

    public CustomerServiceImpl(CustomerEntityRepository repository, CustomerMapper mapper) {
        super(repository, mapper);
    }
}