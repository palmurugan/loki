package com.loki.invoice.core.cache.service;

import com.loki.invoice.core.cache.dto.InvoiceCacheDTO;
import com.loki.invoice.core.cache.dto.InvoiceLineCacheDTO;

import java.util.Optional;

public interface InvoiceLineCacheService {

    Optional<InvoiceCacheDTO> save(InvoiceLineCacheDTO invoiceLineCacheDTO);
}
