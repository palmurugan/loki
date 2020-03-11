package com.loki.invoice.core.cache.service;

import com.loki.invoice.core.cache.dto.InvoiceCacheDTO;

import java.util.List;

public interface InvoiceCacheService {

    InvoiceCacheDTO save(InvoiceCacheDTO invoiceCacheDTO);

    List<InvoiceCacheDTO> findAll();
}
