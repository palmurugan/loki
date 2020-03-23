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

    /**
     * Persist Invoice details to Cache.
     * This one doesn't include invoiceLine details.
     *
     * @param invoiceCacheDTO
     * @return
     */
    @PostMapping
    public ResponseEntity<InvoiceCacheDTO> save(@RequestBody InvoiceCacheDTO invoiceCacheDTO) {
        return new ResponseEntity<>(invoiceCacheService.save(invoiceCacheDTO), HttpStatus.CREATED);
    }

    /**
     * Persist Invoice Line details to cache
     * Returns Invoice details along with invoice line with local calculations
     *
     * @param invoiceLineCacheDTO
     * @return
     */
    @PostMapping("/line")
    public ResponseEntity<InvoiceCacheDTO> save(@RequestBody InvoiceLineCacheDTO invoiceLineCacheDTO) {
        return new ResponseEntity<>(invoiceLineCacheService.save(invoiceLineCacheDTO).get(), HttpStatus.CREATED);
    }

    /**
     * Returns all the invoice details from the cache
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<InvoiceCacheDTO>> findAll() {
        return new ResponseEntity<>(invoiceCacheService.findAll(), HttpStatus.OK);
    }

    /**
     * Returns invoice details along with invoice line
     *
     * @param invoiceId
     * @return InvoiceCacheDTO, InvoiceLineCache
     */
    @GetMapping("/{invoiceId}")
    public ResponseEntity<InvoiceCacheDTO> findById(@PathVariable Long invoiceId) {
        return new ResponseEntity<>(invoiceCacheService.findById(invoiceId), HttpStatus.OK);
    }

    /**
     * Returns invoice details along with invoiceLine (Local calculation)
     *
     * @param invoiceId
     * @return
     */
    @GetMapping("/{invoiceId}/line")
    public ResponseEntity<InvoiceCacheDTO> findByInvoice(@PathVariable Long invoiceId) {
        return new ResponseEntity<>(invoiceLineCacheService.findAllInvoiceLineCache(invoiceId).get(), HttpStatus.OK);
    }
}
