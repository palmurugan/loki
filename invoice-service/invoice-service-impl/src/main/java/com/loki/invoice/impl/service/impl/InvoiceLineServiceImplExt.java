package com.loki.invoice.impl.service.impl;

import com.loki.invoice.impl.service.InvoiceLineServiceExt;
import com.loki.invoice.impl.repository.InvoiceLineEntityRepositoryExt;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class InvoiceLineServiceImplExt implements InvoiceLineServiceExt {

    private InvoiceLineEntityRepositoryExt repository;

    @Inject
    public InvoiceLineServiceImplExt(InvoiceLineEntityRepositoryExt repository) {
        this.repository = repository;
    }
}