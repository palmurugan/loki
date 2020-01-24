package com.loki.customer.core.repository;

import com.loki.customer.core.entity.CustomerEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerEntityRepository extends PagingAndSortingRepository<CustomerEntity, Long> {

}