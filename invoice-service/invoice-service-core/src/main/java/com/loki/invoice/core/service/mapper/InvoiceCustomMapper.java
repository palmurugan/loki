package com.loki.invoice.core.service.mapper;

import com.loki.invoice.core.entity.InvoiceEntity;
import com.loki.invoice.core.entity.InvoiceLineEntity;
import com.loki.invoice.dto.InvoiceDTO;
import com.loki.invoice.dto.InvoiceLineDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author palmuruganc
 */
@Service
public class InvoiceCustomMapper {

    public InvoiceDTO toDTO(InvoiceEntity invoiceEntity) {
        if (invoiceEntity == null) {
            return null;
        }

        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setId(invoiceEntity.getId());
        invoiceDTO.setStatus(invoiceEntity.getStatus());
        invoiceDTO.setCustomerId(invoiceEntity.getCustomerId());
        invoiceDTO.setCurrency(invoiceEntity.getCurrency());
        invoiceDTO.setInvoiceDate(invoiceEntity.getInvoiceDate());
        invoiceDTO.setDueDate(invoiceEntity.getDueDate());
        invoiceDTO.setNotes(invoiceEntity.getNotes());
        invoiceDTO.setPaymentAttempts(invoiceEntity.getPaymentAttempts());
        invoiceDTO.setInvoiceStatus(invoiceEntity.getInvoiceStatus());
        invoiceDTO.setLastRemainder(invoiceEntity.getLastRemainder());
        invoiceDTO.setInvoiceLine(invoiceLineEntityListToInvoiceLineDTOList(invoiceEntity.getInvoiceLine()));
        return invoiceDTO;
    }

    public InvoiceEntity toEntity(InvoiceDTO dto) {
        if (dto == null) {
            return null;
        }

        InvoiceEntity invoiceEntity = new InvoiceEntity();

        invoiceEntity.setStatus(dto.getStatus());
        invoiceEntity.setId(dto.getId());
        invoiceEntity.setCustomerId(dto.getCustomerId());
        invoiceEntity.setCurrency(dto.getCurrency());
        invoiceEntity.setInvoiceDate(dto.getInvoiceDate());
        invoiceEntity.setDueDate(dto.getDueDate());
        invoiceEntity.setNotes(dto.getNotes());
        invoiceEntity.setPaymentAttempts(dto.getPaymentAttempts());
        invoiceEntity.setInvoiceStatus(dto.getInvoiceStatus());
        invoiceEntity.setLastRemainder(dto.getLastRemainder());
        invoiceEntity.setInvoiceLine(invoiceLineDTOListToInvoiceLineEntityList(dto.getInvoiceLine()));

        return invoiceEntity;
    }

    InvoiceLineDTO invoiceLineEntityToInvoiceLineDTO(InvoiceLineEntity invoiceLineEntity) {
        if (invoiceLineEntity == null) {
            return null;
        }
        InvoiceLineDTO invoiceLineDTO = new InvoiceLineDTO();
        invoiceLineDTO.setId(invoiceLineEntity.getId());
        invoiceLineDTO.setStatus(invoiceLineEntity.getStatus());
        invoiceLineDTO.setItemId(invoiceLineEntity.getItemId());
        invoiceLineDTO.setPrice(invoiceLineEntity.getPrice());
        invoiceLineDTO.setQuantity(invoiceLineEntity.getQuantity());
        invoiceLineDTO.setTax(invoiceLineEntity.getTax());
        invoiceLineDTO.setDiscountType(invoiceLineEntity.getDiscountType());
        invoiceLineDTO.setDiscount(invoiceLineEntity.getDiscount());
        invoiceLineDTO.setDescription(invoiceLineEntity.getDescription());
        //invoiceLineDTO.setInvoice(toDTO(invoiceLineEntity.getInvoice()));
        return invoiceLineDTO;
    }

    protected InvoiceLineEntity invoiceLineDTOToInvoiceLineEntity(InvoiceLineDTO invoiceLineDTO) {
        if (invoiceLineDTO == null) {
            return null;
        }

        InvoiceLineEntity invoiceLineEntity = new InvoiceLineEntity();

        invoiceLineEntity.setStatus(invoiceLineDTO.getStatus());
        invoiceLineEntity.setId(invoiceLineDTO.getId());
        invoiceLineEntity.setItemId(invoiceLineDTO.getItemId());
        invoiceLineEntity.setPrice(invoiceLineDTO.getPrice());
        invoiceLineEntity.setQuantity(invoiceLineDTO.getQuantity());
        invoiceLineEntity.setTax(invoiceLineDTO.getTax());
        invoiceLineEntity.setDiscountType(invoiceLineDTO.getDiscountType());
        invoiceLineEntity.setDiscount(invoiceLineDTO.getDiscount());
        invoiceLineEntity.setDescription(invoiceLineDTO.getDescription());
        return invoiceLineEntity;
    }

    protected List<InvoiceLineEntity> invoiceLineDTOListToInvoiceLineEntityList(List<InvoiceLineDTO> list) {
        if (list == null) {
            return null;
        }

        List<InvoiceLineEntity> list1 = new ArrayList<InvoiceLineEntity>(list.size());
        for (InvoiceLineDTO invoiceLineDTO : list) {
            list1.add(invoiceLineDTOToInvoiceLineEntity(invoiceLineDTO));
        }

        return list1;
    }

    protected List<InvoiceLineDTO> invoiceLineEntityListToInvoiceLineDTOList(List<InvoiceLineEntity> list) {
        if (list == null) {
            return null;
        }

        List<InvoiceLineDTO> list1 = new ArrayList<InvoiceLineDTO>(list.size());
        for (InvoiceLineEntity invoiceLineEntity : list) {
            list1.add(invoiceLineEntityToInvoiceLineDTO(invoiceLineEntity));
        }
        return list1;
    }
}
