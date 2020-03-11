package com.loki.invoice.core.cache.repository;

import com.loki.invoice.core.cache.dto.InvoiceCacheDTO;
import org.apache.ignite.springdata20.repository.IgniteRepository;
import org.apache.ignite.springdata20.repository.config.RepositoryConfig;

/**
 * @author palmuruganc
 */
@RepositoryConfig(cacheName = "invoiceCache")
public interface InvoiceCacheRepository extends IgniteRepository<InvoiceCacheDTO, Long> {

}
