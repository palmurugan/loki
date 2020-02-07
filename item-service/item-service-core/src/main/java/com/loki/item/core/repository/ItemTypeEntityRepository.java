package com.loki.item.core.repository;

import com.loki.item.core.entity.ItemTypeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemTypeEntityRepository extends PagingAndSortingRepository<ItemTypeEntity, Long> {

}