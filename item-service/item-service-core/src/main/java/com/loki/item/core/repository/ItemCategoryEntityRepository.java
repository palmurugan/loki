package com.loki.item.core.repository;

import com.loki.item.core.entity.ItemCategoryEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCategoryEntityRepository extends PagingAndSortingRepository<ItemCategoryEntity, Long> {

}