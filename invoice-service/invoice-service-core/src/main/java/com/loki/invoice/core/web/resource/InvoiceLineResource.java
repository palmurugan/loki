package com.loki.invoice.core.web.resource;

import com.loki.common.web.resource.BaseRestResource;
import com.loki.invoice.dto.InvoiceLineDTO;
import com.loki.invoice.core.service.InvoiceLineService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/invoiceline")
public class InvoiceLineResource extends BaseRestResource<InvoiceLineDTO, Long> {

    private InvoiceLineService service;

    @Inject
    public InvoiceLineResource(InvoiceLineService service) {
        super(service);
    }
}