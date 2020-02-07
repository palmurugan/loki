package com.loki.item.impl.web.resource;

import com.loki.item.impl.service.ItemTypeServiceExt;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class ItemTypeResourceExt {

    private ItemTypeServiceExt service;

    @Inject
    public ItemTypeResourceExt(ItemTypeServiceExt service) {
        this.service = service;
    }
}