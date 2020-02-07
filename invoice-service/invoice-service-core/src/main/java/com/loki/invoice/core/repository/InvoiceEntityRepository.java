package com.loki.invoice.core.repository;

import com.loki.invoice.core.entity.InvoiceEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceEntityRepository extends PagingAndSortingRepository<InvoiceEntity, Long> {

}