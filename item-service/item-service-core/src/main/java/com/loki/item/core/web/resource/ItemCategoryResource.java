package com.loki.item.core.web.resource;

import com.loki.common.web.resource.BaseRestResource;
import com.loki.item.dto.ItemCategoryDTO;
import com.loki.item.core.service.ItemCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/itemcategory")
public class ItemCategoryResource extends BaseRestResource<ItemCategoryDTO, Long> {

    private ItemCategoryService service;

    @Inject
    public ItemCategoryResource(ItemCategoryService service) {
        super(service, null);
    }
}