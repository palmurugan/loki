package com.loki.customer.core.mapper;

import com.loki.common.mapper.GenericMapper;
import com.loki.customer.core.entity.CustomerContactEntity;
import com.loki.customer.core.entity.CustomerDetailsEntity;
import com.loki.customer.core.entity.CustomerEntity;
import com.loki.customer.dto.CustomerContactDTO;
import com.loki.customer.dto.CustomerDTO;
import com.loki.customer.dto.CustomerDetailsDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends GenericMapper<CustomerDTO, CustomerEntity> {


}