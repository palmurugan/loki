package com.loki.invoice.core.cache.service;

import com.loki.invoice.core.cache.dto.InvoiceCacheDTO;
import com.loki.invoice.dto.InvoiceDTO;

import java.util.List;

public interface InvoiceCacheService {

    InvoiceCacheDTO save(InvoiceCacheDTO invoiceCacheDTO);

    InvoiceCacheDTO findById(Long invoiceId);

    List<InvoiceCacheDTO> findAll();
}
