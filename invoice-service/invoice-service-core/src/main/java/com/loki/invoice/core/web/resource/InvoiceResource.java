package com.loki.invoice.core.web.resource;

import com.loki.common.web.resource.BaseRestResource;
import com.loki.invoice.dto.InvoiceDTO;
import com.loki.invoice.core.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/invoices")
public class InvoiceResource extends BaseRestResource<InvoiceDTO, Long> {

    private InvoiceService invoiceService;

    @Inject
    public InvoiceResource(InvoiceService invoiceService) {
        super(invoiceService, null);
        this.invoiceService = invoiceService;
    }

    @Override
    @PostMapping
    public ResponseEntity<InvoiceDTO> create(@Valid @RequestBody InvoiceDTO invoiceDTO) {
        return new ResponseEntity<>(invoiceService.saveOrUpdate(invoiceDTO), HttpStatus.CREATED);
    }
}