package com.loki.customer.core.mapper;

import com.loki.common.mapper.GenericMapper;
import com.loki.customer.core.entity.CustomerDetailsEntity;
import com.loki.customer.dto.CustomerDetailsDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerDetailsMapper extends GenericMapper<CustomerDetailsDTO, CustomerDetailsEntity> {

}