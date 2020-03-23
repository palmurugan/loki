package com.loki.invoice.core.service.mapper;

import com.loki.invoice.core.cache.dto.InvoiceCacheDTO;
import com.loki.invoice.core.cache.dto.InvoiceLineCacheDTO;
import com.loki.invoice.core.entity.InvoiceEntity;
import com.loki.invoice.core.entity.InvoiceLineEntity;
import com.loki.invoice.dto.InvoiceDTO;
import com.loki.invoice.dto.InvoiceLineDTO;
import org.springframework.stereotype.Service;

import java.time.*;
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

    public InvoiceDTO fromCacheToDTO(InvoiceCacheDTO invoiceCacheDTO) {
        if (invoiceCacheDTO == null) {
            return null;
        }

        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setStatus("A");
        invoiceDTO.setCustomerId(invoiceCacheDTO.getCustomerId());
        invoiceDTO.setCurrency(invoiceCacheDTO.getCurrency());
        invoiceDTO.setInvoiceDate(invoiceCacheDTO.getInvoiceDate() != null ?
                invoiceCacheDTO.getInvoiceDate().atStartOfDay(ZoneId.systemDefault()).toInstant() : null);
        invoiceDTO.setDueDate(invoiceCacheDTO.getDueDate() != null ?
                invoiceCacheDTO.getDueDate().atStartOfDay(ZoneId.systemDefault()).toInstant() : null);
        invoiceDTO.setNotes(invoiceCacheDTO.getNotes());
        invoiceDTO.setPaymentAttempts(invoiceCacheDTO.getPaymentAttempts());
        invoiceDTO.setInvoiceStatus(invoiceCacheDTO.getInvoiceStatus());
        invoiceDTO.setLastRemainder(invoiceCacheDTO.getLastRemainder() != null ?
                invoiceCacheDTO.getLastRemainder().atStartOfDay(ZoneId.systemDefault()).toInstant() : null);
        invoiceDTO.setInvoiceLine(invoiceLineCacheListToInvoiceLineDTOList(invoiceCacheDTO.getInvoiceLines()));

        return invoiceDTO;
    }

    public InvoiceCacheDTO fromDTOtoCache(InvoiceDTO invoiceDTO) {
        if (invoiceDTO == null) {
            return null;
        }

        InvoiceCacheDTO invoiceCacheDTO = new InvoiceCacheDTO();
        invoiceCacheDTO.setId(invoiceDTO.getId());
        invoiceCacheDTO.setCustomerId(invoiceDTO.getCustomerId());
        invoiceCacheDTO.setCurrency(invoiceDTO.getCurrency());
        invoiceCacheDTO.setInvoiceDate(convertToLocalDate(invoiceDTO.getInvoiceDate()));
        invoiceCacheDTO.setDueDate(convertToLocalDate(invoiceDTO.getDueDate()));
        invoiceCacheDTO.setNotes(invoiceDTO.getNotes());
        invoiceCacheDTO.setPaymentAttempts(invoiceDTO.getPaymentAttempts());
        invoiceCacheDTO.setInvoiceStatus(invoiceDTO.getInvoiceStatus());
        invoiceCacheDTO.setLastRemainder(convertToLocalDate(invoiceDTO.getLastRemainder()));
        return invoiceCacheDTO;
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
        return invoiceLineDTO;
    }

    InvoiceLineDTO invoiceLineCacheToInvoiceLineDTO(InvoiceLineCacheDTO invoiceLineCacheDTO) {
        if (invoiceLineCacheDTO == null) {
            return null;
        }
        InvoiceLineDTO invoiceLineDTO = new InvoiceLineDTO();
        invoiceLineDTO.setStatus("A");
        invoiceLineDTO.setItemId(invoiceLineCacheDTO.getItemId());
        invoiceLineDTO.setPrice(invoiceLineCacheDTO.getPrice());
        invoiceLineDTO.setQuantity(invoiceLineCacheDTO.getQuantity());
        invoiceLineDTO.setTax(invoiceLineCacheDTO.getTax());
        invoiceLineDTO.setDiscountType(invoiceLineCacheDTO.getDiscountType());
        invoiceLineDTO.setDiscount(invoiceLineCacheDTO.getDiscount());
        invoiceLineDTO.setDescription(invoiceLineCacheDTO.getDescription());

        return invoiceLineDTO;
    }

    InvoiceLineCacheDTO invoiceLineDTOToInvoiceLineCacheDTO(InvoiceLineDTO invoiceLineDTO, Long invoiceId) {
        if (invoiceLineDTO == null) {
            return null;
        }
        InvoiceLineCacheDTO invoiceLineCacheDTO = new InvoiceLineCacheDTO();
        invoiceLineCacheDTO.setId(invoiceLineDTO.getId());
        invoiceLineCacheDTO.setInvoiceId(invoiceId);
        invoiceLineCacheDTO.setItemId(invoiceLineDTO.getItemId());
        invoiceLineCacheDTO.setPrice(invoiceLineDTO.getPrice());
        invoiceLineCacheDTO.setQuantity(invoiceLineDTO.getQuantity());
        invoiceLineCacheDTO.setTax(invoiceLineDTO.getTax());
        invoiceLineCacheDTO.setDiscountType(invoiceLineDTO.getDiscountType());
        invoiceLineCacheDTO.setDiscount(invoiceLineDTO.getDiscount());
        invoiceLineCacheDTO.setDescription(invoiceLineDTO.getDescription());

        return invoiceLineCacheDTO;
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

    protected List<InvoiceLineDTO> invoiceLineCacheListToInvoiceLineDTOList(List<InvoiceLineCacheDTO> list) {
        if (list == null) {
            return null;
        }

        List<InvoiceLineDTO> dtoList = new ArrayList<InvoiceLineDTO>(list.size());
        for (InvoiceLineCacheDTO invoiceLineCacheDTO : list) {
            dtoList.add(invoiceLineCacheToInvoiceLineDTO(invoiceLineCacheDTO));
        }
        return dtoList;
    }

    public List<InvoiceLineCacheDTO> invoiceLineDTOListToInvoiceLineCacheList(List<InvoiceLineDTO> list, Long invoiceId) {
        if (list == null) {
            return null;
        }

        List<InvoiceLineCacheDTO> dtoList = new ArrayList<>(list.size());
        for (InvoiceLineDTO invoiceLineDTO : list) {
            dtoList.add(invoiceLineDTOToInvoiceLineCacheDTO(invoiceLineDTO, invoiceId));
        }
        return dtoList;
    }

    private LocalDate convertToLocalDate(Instant instant) {
        return instant != null ? LocalDateTime.ofInstant(instant, ZoneOffset.UTC).toLocalDate() : null;
    }
}
