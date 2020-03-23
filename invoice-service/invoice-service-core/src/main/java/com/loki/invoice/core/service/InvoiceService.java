package com.loki.invoice.core.service;

import com.loki.common.service.IGenericService;
import com.loki.invoice.core.cache.dto.InvoiceCacheDTO;
import com.loki.invoice.dto.InvoiceDTO;

public interface InvoiceService extends IGenericService<InvoiceDTO, Long> {

    InvoiceDTO saveInvoice(Long invoiceId);

}