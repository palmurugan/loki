package com.loki.configuration.core.web.resource;

import com.loki.common.web.resource.BaseRestResource;
import com.loki.configuration.dto.ListOfValueDTO;
import com.loki.configuration.core.service.ListOfValueService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/listofvalue")
public class ListOfValueResource extends BaseRestResource<ListOfValueDTO, Long> {

    private ListOfValueService service;

    @Inject
    public ListOfValueResource(ListOfValueService service) {
        super(service);
    }
}