package com.loki.invoice.core.repository;

import com.loki.invoice.core.entity.InvoiceLineEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceLineEntityRepository extends PagingAndSortingRepository<InvoiceLineEntity, Long> {

}