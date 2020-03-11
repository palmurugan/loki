package com.loki.invoice.core.cache.repository;

import com.loki.invoice.core.cache.dto.InvoiceLineCacheDTO;
import org.apache.ignite.springdata20.repository.IgniteRepository;
import org.apache.ignite.springdata20.repository.config.RepositoryConfig;

@RepositoryConfig(cacheName = "invoiceLineCache")
public interface InvoiceLineCacheRepository extends IgniteRepository<InvoiceLineCacheDTO, Long> {

}
