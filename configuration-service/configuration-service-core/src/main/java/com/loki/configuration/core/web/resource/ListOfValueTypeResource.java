package com.loki.configuration.core.web.resource;

import com.loki.common.web.resource.BaseRestResource;
import com.loki.configuration.dto.ListOfValueTypeDTO;
import com.loki.configuration.core.service.ListOfValueTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/listofvaluetype")
public class ListOfValueTypeResource extends BaseRestResource<ListOfValueTypeDTO, Long> {

    private ListOfValueTypeService service;

    @Inject
    public ListOfValueTypeResource(ListOfValueTypeService service) {
        super(service);
    }
}