package com.loki.invoice.core.cache.service.impl;

import com.loki.common.utils.ArithmeticUtils;
import com.loki.invoice.core.cache.dto.InvoiceCacheDTO;
import com.loki.invoice.core.cache.dto.InvoiceLineCacheDTO;
import com.loki.invoice.core.cache.repository.InvoiceCacheRepository;
import com.loki.invoice.core.cache.repository.InvoiceLineCacheRepository;
import com.loki.invoice.core.cache.service.InvoiceLineCacheService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.loki.common.utils.CalculationUtil.fnDecimalMultiplication;
import static com.loki.common.utils.CommonUtils.getRandomNumber;

/**
 * @author palmuruganc
 */
@Service
public class InvoiceLineCacheServiceImpl implements InvoiceLineCacheService {

    private InvoiceCacheRepository invoiceCacheRepository;

    private InvoiceLineCacheRepository invoiceLineCacheRepository;

    public InvoiceLineCacheServiceImpl(InvoiceLineCacheRepository invoiceLineCacheRepository, InvoiceCacheRepository invoiceCacheRepository) {
        this.invoiceLineCacheRepository = invoiceLineCacheRepository;
        this.invoiceCacheRepository = invoiceCacheRepository;
    }

    @Override
    public Optional<InvoiceCacheDTO> save(InvoiceLineCacheDTO invoiceLineCacheDTO) {
        invoiceLineCacheDTO.setId(getRandomNumber());
        invoiceLineCacheRepository.save(invoiceLineCacheDTO.getId(), invoiceLineCacheDTO);
        return prepareInvoiceData(invoiceLineCacheDTO.getInvoiceId());
    }

    /**
     * Preparing invoice data along with total, tax, discount based on the invoice line
     *
     * @param invoiceId
     * @return
     */
    private Optional<InvoiceCacheDTO> prepareInvoiceData(Long invoiceId) {
        /** Error will thrown if the system doesn't have any data for the requested invoice */
        Optional<InvoiceCacheDTO> invoiceCacheDTO = invoiceCacheRepository.findById(invoiceId);
        invoiceCacheDTO.orElseThrow(RuntimeException::new);

        List<InvoiceLineCacheDTO> invoiceLineCacheDTOList = StreamSupport.stream(invoiceLineCacheRepository.findAll().spliterator(), Boolean.FALSE).collect(Collectors.toList());
        if (!invoiceLineCacheDTOList.isEmpty()) {
            invoiceLineCacheDTOList.stream().map(this::calculateTotal).collect(Collectors.toList());
        }

        invoiceCacheDTO.get().setTotal(invoiceLineCacheDTOList.stream().map(InvoiceLineCacheDTO::getTotal).reduce(BigDecimal.ZERO, ArithmeticUtils::add));
        return invoiceCacheDTO;
    }

    /**
     * Calculating total amount for each invoiceLine (cost * quantity)
     *
     * @param invoiceLineCacheDTO
     * @return
     */
    private InvoiceLineCacheDTO calculateTotal(InvoiceLineCacheDTO invoiceLineCacheDTO) {
        invoiceLineCacheDTO.setTotal(fnDecimalMultiplication.apply(invoiceLineCacheDTO.getPrice(),
                new BigDecimal(invoiceLineCacheDTO.getQuantity())));
        return invoiceLineCacheDTO;
    }
}
