package com.loki.item.impl.service.impl;

import com.loki.item.impl.service.ItemPriceServiceExt;
import com.loki.item.impl.repository.ItemPriceEntityRepositoryExt;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ItemPriceServiceImplExt implements ItemPriceServiceExt {

    private ItemPriceEntityRepositoryExt repository;

    @Inject
    public ItemPriceServiceImplExt(ItemPriceEntityRepositoryExt repository) {
        this.repository = repository;
    }
}