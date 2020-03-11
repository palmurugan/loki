package com.loki.invoice.core.service.impl;

import com.loki.common.service.impl.GenericService;
import com.loki.invoice.core.entity.InvoiceEntity;
import com.loki.invoice.core.mapper.InvoiceMapper;
import com.loki.invoice.core.repository.InvoiceEntityRepository;
import com.loki.invoice.core.service.InvoiceService;
import com.loki.invoice.core.service.mapper.InvoiceCustomMapper;
import com.loki.invoice.dto.InvoiceDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InvoiceServiceImpl extends GenericService<InvoiceDTO, InvoiceEntity, Long> implements InvoiceService {

    private InvoiceEntityRepository invoiceEntityRepository;

    private InvoiceMapper mapper;

    private InvoiceCustomMapper invoiceCustomMapper;

    public InvoiceServiceImpl(InvoiceEntityRepository repository, InvoiceMapper mapper, InvoiceCustomMapper invoiceCustomMapper) {
        super(repository, mapper);
        this.invoiceEntityRepository = repository;
        this.mapper = mapper;
        this.invoiceCustomMapper = invoiceCustomMapper;
    }

    @Override
    public InvoiceDTO saveOrUpdate(InvoiceDTO invoiceDTO) {
        InvoiceEntity invoiceEntity = invoiceCustomMapper.toEntity(invoiceDTO);
        invoiceEntity.getInvoiceLine().forEach(entity -> entity.setInvoice(invoiceEntity));
        return invoiceCustomMapper.toDTO(invoiceEntityRepository.save(invoiceEntity));
    }

    @Override
    public Page<InvoiceDTO> findAll(Pageable pageable) {
        return invoiceEntityRepository.findAll(pageable).map(invoiceCustomMapper::toDTO);
    }

    @Override
    public Optional<InvoiceDTO> findByKey(Long id) {
        return invoiceEntityRepository.findById(id).map(invoiceCustomMapper::toDTO);
    }
}