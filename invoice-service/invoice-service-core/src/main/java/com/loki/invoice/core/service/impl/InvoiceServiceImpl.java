package com.loki.invoice.core.service.impl;

import com.loki.common.service.impl.GenericService;
import com.loki.invoice.core.entity.InvoiceEntity;
import com.loki.invoice.dto.InvoiceDTO;
import com.loki.invoice.core.mapper.InvoiceMapper;
import com.loki.invoice.core.repository.InvoiceEntityRepository;
import com.loki.invoice.core.service.InvoiceService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl extends GenericService<InvoiceDTO, InvoiceEntity, Long> implements InvoiceService {

    private InvoiceEntityRepository repository;

    private InvoiceMapper mapper;

    public InvoiceServiceImpl(InvoiceEntityRepository repository, InvoiceMapper mapper) {
        super(repository, mapper);
    }
}