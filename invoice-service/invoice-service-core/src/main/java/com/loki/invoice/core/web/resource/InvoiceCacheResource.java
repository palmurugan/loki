package com.loki.invoice.core.web.resource;

import com.loki.invoice.core.cache.dto.InvoiceCacheDTO;
import com.loki.invoice.core.cache.dto.InvoiceLineCacheDTO;
import com.loki.invoice.core.cache.service.InvoiceCacheService;
import com.loki.invoice.core.cache.service.InvoiceLineCacheService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/invoice-cache")
public class InvoiceCacheResource {

    private InvoiceCacheService invoiceCacheService;

    private InvoiceLineCacheService invoiceLineCacheService;

    public InvoiceCacheResource(InvoiceCacheService invoiceCacheService, InvoiceLineCacheService invoiceLineCacheService) {
        this.invoiceCacheService = Objects.requireNonNull(invoiceCacheService, "InvoiceCacheService should not be null");
        this.invoiceLineCacheService = Objects.requireNonNull(invoiceLineCacheService, "InvoiceLineCacheService Should not be null");
    }

    @PostMapping
    public ResponseEntity<InvoiceCacheDTO> save(@RequestBody InvoiceCacheDTO invoiceCacheDTO) {
        return new ResponseEntity<>(invoiceCacheService.save(invoiceCacheDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<InvoiceCacheDTO>> findAll() {
        return new ResponseEntity<>(invoiceCacheService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/line")
    public ResponseEntity<InvoiceCacheDTO> save(@RequestBody InvoiceLineCacheDTO invoiceLineCacheDTO) {
        return new ResponseEntity<>(invoiceLineCacheService.save(invoiceLineCacheDTO).get(), HttpStatus.CREATED);
    }
}
