package com.loki.invoice.core.cache.service.impl;

import com.loki.common.utils.ArithmeticUtils;
import com.loki.invoice.core.cache.dto.InvoiceCacheDTO;
import com.loki.invoice.core.cache.dto.InvoiceLineCacheDTO;
import com.loki.invoice.core.cache.repository.InvoiceCacheRepository;
import com.loki.invoice.core.cache.repository.InvoiceLineCacheRepository;
import com.loki.invoice.core.cache.service.InvoiceLineCacheService;
import com.loki.invoice.core.util.TaxValueEnum;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static com.loki.common.utils.CalculationUtil.*;
import static com.loki.common.utils.CommonUtils.getUniqueId;

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
        if(invoiceLineCacheDTO.getId() == null)
            invoiceLineCacheDTO.setId(getUniqueId());

        invoiceLineCacheRepository.save(invoiceLineCacheDTO.getId(), invoiceLineCacheDTO);
        return prepareInvoiceData(invoiceLineCacheDTO.getInvoiceId());
    }

    @Override
    public void saveAll(List<InvoiceLineCacheDTO> invoiceLineCacheDTOS) {
        invoiceLineCacheDTOS.forEach(invoiceLineCache  -> save(invoiceLineCache));
    }

    @Override
    public Optional<InvoiceCacheDTO> findAllInvoiceLineCache(Long invoiceId) {
        return prepareInvoiceData(invoiceId);
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
        if (!invoiceCacheDTO.isPresent()) {
            throw new RuntimeException("Invoice Not Found!");
        }

        /**
         * Retrieving all the invoice line since spring data ignite not supporting query with the version 2.8.0
         * Have to change this logic as soon since its a bad way of fetching data.
         */
        List<InvoiceLineCacheDTO> invoiceLineCacheDTOList = StreamSupport.stream(invoiceLineCacheRepository.findAll().spliterator(), Boolean.FALSE)
                .filter(invoiceLine -> invoiceLine.getInvoiceId().equals(invoiceId)).collect(Collectors.toList());
        if (!invoiceLineCacheDTOList.isEmpty()) {
            invoiceLineCacheDTOList.stream().map(this::doCalculations).collect(Collectors.toList());
        }

        /** Set total, tax, discount, invoiceline to the parent invoice */
        invoiceCacheDTO.get().setTotal(invoiceLineCacheDTOList.stream().map(InvoiceLineCacheDTO::getOriginalPrice).reduce(BigDecimal.ZERO, ArithmeticUtils::add));
        invoiceCacheDTO.get().setInvoiceLines(invoiceLineCacheDTOList);
        return invoiceCacheDTO;
    }

    /**
     * Calculating total amount for each invoiceLine (cost * quantity)
     *
     * @param invoiceLineCacheDTO
     * @return
     */
    @NotNull
    @Contract("_ -> param1")
    private InvoiceLineCacheDTO doCalculations(@NotNull InvoiceLineCacheDTO invoiceLineCacheDTO) {
        /** Calculating & setting original price **/
        invoiceLineCacheDTO.setOriginalPrice(fnDecimalMultiplication.apply(invoiceLineCacheDTO.getPrice(),
                BigDecimal.valueOf(invoiceLineCacheDTO.getQuantity())));

        /** Calculating and setting GST | C-GST & S-GST */
        invoiceLineCacheDTO.setCGST(fnCalculateGST.andThen(fnDecimalDivideByTwo).apply(invoiceLineCacheDTO.getOriginalPrice(),
                getTaxValue(invoiceLineCacheDTO.getTax())));
        invoiceLineCacheDTO.setSGST(fnCalculateGST.andThen(fnDecimalDivideByTwo).apply(invoiceLineCacheDTO.getOriginalPrice(),
                getTaxValue(invoiceLineCacheDTO.getTax())));

        return invoiceLineCacheDTO;
    }

    /**
     * TODO have to enhance this method to get the tax value
     * @param taxCode
     * @return
     */
    private BigDecimal getTaxValue(String taxCode) {
        return TaxValueEnum.valueOf(taxCode).getValue();
    }
}
