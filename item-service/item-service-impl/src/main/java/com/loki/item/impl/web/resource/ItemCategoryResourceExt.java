package com.loki.item.impl.web.resource;

import com.loki.item.impl.service.ItemCategoryServiceExt;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class ItemCategoryResourceExt {

    private ItemCategoryServiceExt service;

    @Inject
    public ItemCategoryResourceExt(ItemCategoryServiceExt service) {
        this.service = service;
    }
}