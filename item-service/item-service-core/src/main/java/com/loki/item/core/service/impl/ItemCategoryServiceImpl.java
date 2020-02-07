package com.loki.item.core.service.impl;

import com.loki.common.service.impl.GenericService;
import com.loki.item.core.entity.ItemCategoryEntity;
import com.loki.item.dto.ItemCategoryDTO;
import com.loki.item.core.mapper.ItemCategoryMapper;
import com.loki.item.core.repository.ItemCategoryEntityRepository;
import com.loki.item.core.service.ItemCategoryService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemCategoryServiceImpl extends GenericService<ItemCategoryDTO, ItemCategoryEntity, Long> implements ItemCategoryService {

    private ItemCategoryEntityRepository repository;

    private ItemCategoryMapper mapper;

    public ItemCategoryServiceImpl(ItemCategoryEntityRepository repository, ItemCategoryMapper mapper) {
        super(repository, mapper);
    }
}