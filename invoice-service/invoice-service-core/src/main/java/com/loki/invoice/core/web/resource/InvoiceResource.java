package com.loki.invoice.core.web.resource;

import com.loki.common.web.resource.BaseRestResource;
import com.loki.invoice.dto.InvoiceDTO;
import com.loki.invoice.core.service.InvoiceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceResource extends BaseRestResource<InvoiceDTO, Long> {

    private InvoiceService service;

    @Inject
    public InvoiceResource(InvoiceService service) {
        super(service);
    }
}