package com.loki.item.core.service.impl;

import com.loki.common.service.impl.GenericService;
import com.loki.item.core.entity.ItemTypeEntity;
import com.loki.item.dto.ItemTypeDTO;
import com.loki.item.core.mapper.ItemTypeMapper;
import com.loki.item.core.repository.ItemTypeEntityRepository;
import com.loki.item.core.service.ItemTypeService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemTypeServiceImpl extends GenericService<ItemTypeDTO, ItemTypeEntity, Long> implements ItemTypeService {

    private ItemTypeEntityRepository repository;

    private ItemTypeMapper mapper;

    public ItemTypeServiceImpl(ItemTypeEntityRepository repository, ItemTypeMapper mapper) {
        super(repository, mapper);
    }
}