package com.loki.item.core.repository;

import com.loki.item.core.entity.ItemPriceEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPriceEntityRepository extends PagingAndSortingRepository<ItemPriceEntity, Long> {

}