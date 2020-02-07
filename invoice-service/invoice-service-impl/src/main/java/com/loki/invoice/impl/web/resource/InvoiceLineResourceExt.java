package com.loki.invoice.impl.web.resource;

import com.loki.invoice.impl.service.InvoiceLineServiceExt;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class InvoiceLineResourceExt {

    private InvoiceLineServiceExt service;

    @Inject
    public InvoiceLineResourceExt(InvoiceLineServiceExt service) {
        this.service = service;
    }
}