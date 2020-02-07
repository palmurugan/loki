package com.loki.invoice.core.service.impl;

import com.loki.common.service.impl.GenericService;
import com.loki.invoice.core.entity.InvoiceLineEntity;
import com.loki.invoice.dto.InvoiceLineDTO;
import com.loki.invoice.core.mapper.InvoiceLineMapper;
import com.loki.invoice.core.repository.InvoiceLineEntityRepository;
import com.loki.invoice.core.service.InvoiceLineService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class InvoiceLineServiceImpl extends GenericService<InvoiceLineDTO, InvoiceLineEntity, Long> implements InvoiceLineService {

    private InvoiceLineEntityRepository repository;

    private InvoiceLineMapper mapper;

    public InvoiceLineServiceImpl(InvoiceLineEntityRepository repository, InvoiceLineMapper mapper) {
        super(repository, mapper);
    }
}