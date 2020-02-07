package com.loki.item.core.service.impl;

import com.loki.common.service.impl.GenericService;
import com.loki.item.core.entity.ItemEntity;
import com.loki.item.dto.ItemDTO;
import com.loki.item.core.mapper.ItemMapper;
import com.loki.item.core.repository.ItemEntityRepository;
import com.loki.item.core.service.ItemService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends GenericService<ItemDTO, ItemEntity, Long> implements ItemService {

    private ItemEntityRepository repository;

    private ItemMapper mapper;

    public ItemServiceImpl(ItemEntityRepository repository, ItemMapper mapper) {
        super(repository, mapper);
    }
}