package com.loki.item.core.web.resource;

import com.loki.common.web.resource.BaseRestResource;
import com.loki.item.dto.ItemPriceDTO;
import com.loki.item.core.service.ItemPriceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/itemprice")
public class ItemPriceResource extends BaseRestResource<ItemPriceDTO, Long> {

    private ItemPriceService service;

    @Inject
    public ItemPriceResource(ItemPriceService service) {
        super(service, null);
    }
}