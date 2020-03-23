package com.loki.invoice.core.web.resource;

import com.loki.common.web.resource.BaseRestResource;
import com.loki.invoice.core.service.InvoiceService;
import com.loki.invoice.dto.InvoiceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Optional;

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

    @PostMapping("/{invoiceId}")
    public ResponseEntity<InvoiceDTO> saveInvoice(@PathVariable Long invoiceId) {
        return new ResponseEntity<>(invoiceService.saveInvoice(invoiceId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<InvoiceDTO>> findAll(Pageable pageable) {
        return new ResponseEntity<>(invoiceService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceDTO> find(@PathVariable Long id) {
        Optional<InvoiceDTO> result = invoiceService.findByKey(id);
        return new ResponseEntity<>(result.isPresent() ? result.get() : null, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceDTO> update(@PathVariable Long id, @Valid @RequestBody InvoiceDTO invoiceDTO) {
        return new ResponseEntity<>(invoiceService.saveOrUpdate(invoiceDTO), HttpStatus.OK);
    }
}