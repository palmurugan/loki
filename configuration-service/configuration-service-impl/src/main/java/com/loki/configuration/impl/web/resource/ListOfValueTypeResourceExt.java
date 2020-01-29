package com.loki.configuration.impl.web.resource;

import com.loki.configuration.impl.service.ListOfValueTypeServiceExt;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class ListOfValueTypeResourceExt {

    private ListOfValueTypeServiceExt service;

    @Inject
    public ListOfValueTypeResourceExt(ListOfValueTypeServiceExt service) {
        this.service = service;
    }
}