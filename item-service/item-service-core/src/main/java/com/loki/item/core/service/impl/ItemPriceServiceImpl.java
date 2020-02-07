package com.loki.item.core.service.impl;

import com.loki.common.service.impl.GenericService;
import com.loki.item.core.entity.ItemPriceEntity;
import com.loki.item.dto.ItemPriceDTO;
import com.loki.item.core.mapper.ItemPriceMapper;
import com.loki.item.core.repository.ItemPriceEntityRepository;
import com.loki.item.core.service.ItemPriceService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemPriceServiceImpl extends GenericService<ItemPriceDTO, ItemPriceEntity, Long> implements ItemPriceService {

    private ItemPriceEntityRepository repository;

    private ItemPriceMapper mapper;

    public ItemPriceServiceImpl(ItemPriceEntityRepository repository, ItemPriceMapper mapper) {
        super(repository, mapper);
    }
}