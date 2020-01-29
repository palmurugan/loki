package com.loki.customer.core.mapper;

import com.loki.common.mapper.GenericMapper;
import com.loki.customer.core.entity.CustomerContactEntity;
import com.loki.customer.dto.CustomerContactDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerContactMapper extends GenericMapper<CustomerContactDTO, CustomerContactEntity> {
}
