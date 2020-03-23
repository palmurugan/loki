package com.loki.invoice.core.cache.service.impl;

import com.loki.invoice.core.cache.dto.InvoiceCacheDTO;
import com.loki.invoice.core.cache.repository.InvoiceCacheRepository;
import com.loki.invoice.core.cache.service.InvoiceCacheService;
import com.loki.invoice.core.cache.service.InvoiceLineCacheService;
import com.loki.invoice.core.service.InvoiceService;
import com.loki.invoice.core.service.mapper.InvoiceCustomMapper;
import com.loki.invoice.dto.InvoiceDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.loki.common.utils.CommonUtils.getUniqueId;

@Service
public class InvoiceCacheServiceImpl implements InvoiceCacheService {

    private InvoiceCacheRepository invoiceCacheRepository;
    private InvoiceLineCacheService invoiceLineCacheService;
    private InvoiceService invoiceService;
    private InvoiceCustomMapper invoiceCustomMapper;

    public InvoiceCacheServiceImpl(InvoiceCacheRepository invoiceCacheRepository,
                                   InvoiceLineCacheService invoiceLineCacheService, InvoiceService invoiceService,
                                   InvoiceCustomMapper invoiceCustomMapper) {
        this.invoiceCacheRepository = invoiceCacheRepository;
        this.invoiceLineCacheService = invoiceLineCacheService;
        this.invoiceService = invoiceService;
        this.invoiceCustomMapper = invoiceCustomMapper;
    }

    @Override
    public InvoiceCacheDTO save(InvoiceCacheDTO invoiceCacheDTO) {
        /** Setting random number as Id and Key for persisting invoice data */
        if (invoiceCacheDTO.getId() == null)
            invoiceCacheDTO.setId(getUniqueId());

        return invoiceCacheRepository.save(invoiceCacheDTO.getId(), invoiceCacheDTO);
    }

    @Override
    public InvoiceCacheDTO findById(Long invoiceId) {
        Optional<InvoiceCacheDTO> invoiceCacheDTO = invoiceCacheRepository.findById(invoiceId);
        return invoiceCacheDTO.isPresent() ?
                invoiceLineCacheService.findAllInvoiceLineCache(invoiceId).get() : importDataToCache(invoiceId).get();
    }

    @Override
    public List<InvoiceCacheDTO> findAll() {
        return StreamSupport.stream(invoiceCacheRepository.findAll().spliterator(), Boolean.FALSE)
                .collect(Collectors.toList());
    }

    private Optional<InvoiceCacheDTO> importDataToCache(Long invoiceId) {
        Optional<InvoiceDTO> invoiceDTO = invoiceService.findByKey(invoiceId);
        if (!invoiceDTO.isPresent()) {
            throw new RuntimeException("Invoice Not Found!");
        }

        /** Save data to local cache */
        save(invoiceCustomMapper.fromDTOtoCache(invoiceDTO.get()));
        if (invoiceDTO.get().getInvoiceLine() != null) {
            invoiceLineCacheService.saveAll(invoiceCustomMapper.invoiceLineDTOListToInvoiceLineCacheList(
                    invoiceDTO.get().getInvoiceLine(), invoiceId));
        }
        return invoiceLineCacheService.findAllInvoiceLineCache(invoiceId);
    }
}
