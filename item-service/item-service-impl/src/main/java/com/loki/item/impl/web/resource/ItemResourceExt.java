package com.loki.item.impl.web.resource;

import com.loki.item.impl.service.ItemServiceExt;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class ItemResourceExt {

    private ItemServiceExt service;

    @Inject
    public ItemResourceExt(ItemServiceExt service) {
        this.service = service;
    }
}