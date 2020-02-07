package com.loki.invoice.impl.web.resource;

import com.loki.invoice.impl.service.InvoiceServiceExt;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class InvoiceResourceExt {

    private InvoiceServiceExt service;

    @Inject
    public InvoiceResourceExt(InvoiceServiceExt service) {
        this.service = service;
    }
}