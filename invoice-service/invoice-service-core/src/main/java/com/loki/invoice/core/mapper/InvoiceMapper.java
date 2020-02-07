package com.loki.invoice.core.mapper;

import com.loki.common.mapper.GenericMapper;
import com.loki.invoice.core.entity.InvoiceEntity;
import com.loki.invoice.dto.InvoiceDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper extends GenericMapper<InvoiceDTO, InvoiceEntity> {

}