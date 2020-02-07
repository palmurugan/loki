package com.loki.item.core.web.resource;

import com.loki.common.web.resource.BaseRestResource;
import com.loki.item.dto.ItemTypeDTO;
import com.loki.item.core.service.ItemTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/itemtype")
public class ItemTypeResource extends BaseRestResource<ItemTypeDTO, Long> {

    private ItemTypeService service;

    @Inject
    public ItemTypeResource(ItemTypeService service) {
        super(service);
    }
}