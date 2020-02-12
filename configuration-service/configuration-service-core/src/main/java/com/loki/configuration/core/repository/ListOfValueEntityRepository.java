package com.loki.configuration.core.repository;

import com.loki.configuration.core.entity.ListOfValueEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListOfValueEntityRepository extends PagingAndSortingRepository<ListOfValueEntity, Long> {

    List<ListOfValueEntity> findByListOfValueTypeName(String name);

}