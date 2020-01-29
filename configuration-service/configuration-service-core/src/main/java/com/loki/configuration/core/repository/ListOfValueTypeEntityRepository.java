package com.loki.configuration.core.repository;

import com.loki.configuration.core.entity.ListOfValueTypeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListOfValueTypeEntityRepository extends PagingAndSortingRepository<ListOfValueTypeEntity, Long> {

}