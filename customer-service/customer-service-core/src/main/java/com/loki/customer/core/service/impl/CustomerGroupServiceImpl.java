package com.loki.customer.core.service.impl;

import com.loki.common.service.impl.GenericService;
import com.loki.customer.core.entity.CustomerGroupEntity;
import com.loki.customer.dto.CustomerGroupDTO;
import com.loki.customer.core.mapper.CustomerGroupMapper;
import com.loki.customer.core.repository.CustomerGroupEntityRepository;
import com.loki.customer.core.service.CustomerGroupService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerGroupServiceImpl extends GenericService<CustomerGroupDTO, CustomerGroupEntity, Long> implements CustomerGroupService {

    private CustomerGroupEntityRepository repository;

    private CustomerGroupMapper mapper;

    public CustomerGroupServiceImpl(CustomerGroupEntityRepository repository, CustomerGroupMapper mapper) {
        super(repository, mapper);
    }
}