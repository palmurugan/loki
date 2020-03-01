package com.loki.item.core.web.resource;

import com.loki.common.web.resource.BaseRestResource;
import com.loki.item.dto.ItemDTO;
import com.loki.item.core.service.ItemService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/item")
public class ItemResource extends BaseRestResource<ItemDTO, Long> {

    private ItemService service;

    @Inject
    public ItemResource(ItemService service) {
        super(service, null);
    }
}