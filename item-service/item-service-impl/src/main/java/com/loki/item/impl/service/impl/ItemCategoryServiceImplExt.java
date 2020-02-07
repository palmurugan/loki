package com.loki.item.impl.service.impl;

import com.loki.item.impl.service.ItemCategoryServiceExt;
import com.loki.item.impl.repository.ItemCategoryEntityRepositoryExt;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ItemCategoryServiceImplExt implements ItemCategoryServiceExt {

    private ItemCategoryEntityRepositoryExt repository;

    @Inject
    public ItemCategoryServiceImplExt(ItemCategoryEntityRepositoryExt repository) {
        this.repository = repository;
    }
}