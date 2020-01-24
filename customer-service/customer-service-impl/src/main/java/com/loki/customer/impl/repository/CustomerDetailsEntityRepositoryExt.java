package com.loki.customer.impl.repository;

import com.loki.customer.core.entity.CustomerDetailsEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsEntityRepositoryExt extends PagingAndSortingRepository<CustomerDetailsEntity, Long> {

}