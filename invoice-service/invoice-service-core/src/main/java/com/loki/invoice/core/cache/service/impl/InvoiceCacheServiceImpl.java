package com.loki.invoice.core.cache.service.impl;

import com.loki.invoice.core.cache.dto.InvoiceCacheDTO;
import com.loki.invoice.core.cache.repository.InvoiceCacheRepository;
import com.loki.invoice.core.cache.service.InvoiceCacheService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.loki.common.utils.CommonUtils.getUniqueId;

@Service
public class InvoiceCacheServiceImpl implements InvoiceCacheService {

    private InvoiceCacheRepository invoiceCacheRepository;

    public InvoiceCacheServiceImpl(InvoiceCacheRepository invoiceCacheRepository) {
        this.invoiceCacheRepository = invoiceCacheRepository;
    }

    @Override
    public InvoiceCacheDTO save(InvoiceCacheDTO invoiceCacheDTO) {
        /** Setting random number as Id and Key for persisting invoice data */
        invoiceCacheDTO.setId(getUniqueId());
        return invoiceCacheRepository.save(invoiceCacheDTO.getId(), invoiceCacheDTO);
    }

    @Override
    public List<InvoiceCacheDTO> findAll() {
        return StreamSupport.stream(invoiceCacheRepository.findAll().spliterator(), Boolean.FALSE).collect(Collectors.toList());
    }
}
