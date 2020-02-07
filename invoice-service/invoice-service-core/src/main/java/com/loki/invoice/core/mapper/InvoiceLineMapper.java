package com.loki.invoice.core.mapper;

import com.loki.common.mapper.GenericMapper;
import com.loki.invoice.core.entity.InvoiceLineEntity;
import com.loki.invoice.dto.InvoiceLineDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceLineMapper extends GenericMapper<InvoiceLineDTO, InvoiceLineEntity> {

}