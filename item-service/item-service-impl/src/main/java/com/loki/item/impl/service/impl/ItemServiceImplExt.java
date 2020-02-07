package com.loki.item.impl.service.impl;

import com.loki.item.impl.service.ItemServiceExt;
import com.loki.item.impl.repository.ItemEntityRepositoryExt;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ItemServiceImplExt implements ItemServiceExt {

    private ItemEntityRepositoryExt repository;

    @Inject
    public ItemServiceImplExt(ItemEntityRepositoryExt repository) {
        this.repository = repository;
    }
}