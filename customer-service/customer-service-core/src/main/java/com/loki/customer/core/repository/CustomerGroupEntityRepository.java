package com.loki.customer.core.repository;

import com.loki.customer.core.entity.CustomerGroupEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerGroupEntityRepository extends PagingAndSortingRepository<CustomerGroupEntity, Long> {

}