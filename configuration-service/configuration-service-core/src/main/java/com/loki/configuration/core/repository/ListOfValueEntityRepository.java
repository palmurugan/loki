package com.loki.configuration.core.repository;

import com.loki.configuration.core.entity.ListOfValueEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListOfValueEntityRepository extends PagingAndSortingRepository<ListOfValueEntity, Long> {

}