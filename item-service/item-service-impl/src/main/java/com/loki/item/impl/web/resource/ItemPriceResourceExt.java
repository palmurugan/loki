package com.loki.item.impl.web.resource;

import com.loki.item.impl.service.ItemPriceServiceExt;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class ItemPriceResourceExt {

    private ItemPriceServiceExt service;

    @Inject
    public ItemPriceResourceExt(ItemPriceServiceExt service) {
        this.service = service;
    }
}