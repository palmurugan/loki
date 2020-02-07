package com.loki.item.impl.service.impl;

import com.loki.item.impl.service.ItemTypeServiceExt;
import com.loki.item.impl.repository.ItemTypeEntityRepositoryExt;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ItemTypeServiceImplExt implements ItemTypeServiceExt {

    private ItemTypeEntityRepositoryExt repository;

    @Inject
    public ItemTypeServiceImplExt(ItemTypeEntityRepositoryExt repository) {
        this.repository = repository;
    }
}