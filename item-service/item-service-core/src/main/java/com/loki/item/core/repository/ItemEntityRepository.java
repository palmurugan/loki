package com.loki.item.core.repository;

import com.loki.item.core.entity.ItemEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemEntityRepository extends PagingAndSortingRepository<ItemEntity, Long> {

}