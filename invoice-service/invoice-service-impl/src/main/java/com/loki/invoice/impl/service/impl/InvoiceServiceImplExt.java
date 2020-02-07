package com.loki.invoice.impl.service.impl;

import com.loki.invoice.impl.service.InvoiceServiceExt;
import com.loki.invoice.impl.repository.InvoiceEntityRepositoryExt;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class InvoiceServiceImplExt implements InvoiceServiceExt {

    private InvoiceEntityRepositoryExt repository;

    @Inject
    public InvoiceServiceImplExt(InvoiceEntityRepositoryExt repository) {
        this.repository = repository;
    }
}