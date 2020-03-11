package com.loki.bms.config;

import com.loki.invoice.core.cache.dto.InvoiceCacheDTO;
import com.loki.invoice.core.cache.dto.InvoiceLineCacheDTO;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.springdata20.repository.config.EnableIgniteRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author palmuruganc
 */
@Configuration
@EnableIgniteRepositories({"com.loki.invoice.core.cache.repository"})
public class CachingConfiguration {

    private static final String INVOICE_CACHE = "invoiceCache";
    private static final String INVOICE_LINE_CACHE = "invoiceLineCache";

    /**
     * Ignite Cache configuration & Initialization
     *
     * @return
     */
    @Bean
    public Ignite igniteInstance() {
        IgniteConfiguration igniteConfiguration = new IgniteConfiguration();
        igniteConfiguration.setIgniteInstanceName("loki");

        igniteConfiguration.setCacheConfiguration(cacheConfigurations());
        return Ignition.start(igniteConfiguration);
    }

    @Bean
    public CacheConfiguration[] cacheConfigurations() {
        List<CacheConfiguration> cacheConfigurations = new ArrayList<>();

        CacheConfiguration invoiceCacheConfig = new CacheConfiguration(INVOICE_CACHE);
        invoiceCacheConfig.setIndexedTypes(Long.class, InvoiceCacheDTO.class);

        CacheConfiguration invoiceLineCacheConfig = new CacheConfiguration(INVOICE_LINE_CACHE);
        invoiceLineCacheConfig.setIndexedTypes(Long.class, InvoiceLineCacheDTO.class);

        cacheConfigurations.add(invoiceCacheConfig);
        cacheConfigurations.add(invoiceLineCacheConfig);
        return cacheConfigurations.toArray(new CacheConfiguration[cacheConfigurations.size()]);
    }
}
