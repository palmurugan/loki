package com.loki.configuration.impl.web.resource;

import com.loki.configuration.impl.service.ListOfValueServiceExt;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class ListOfValueResourceExt {

    private ListOfValueServiceExt service;

    @Inject
    public ListOfValueResourceExt(ListOfValueServiceExt service) {
        this.service = service;
    }
}