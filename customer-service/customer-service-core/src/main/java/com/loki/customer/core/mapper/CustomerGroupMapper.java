package com.loki.customer.core.mapper;

import com.loki.common.mapper.GenericMapper;
import com.loki.customer.core.entity.CustomerGroupEntity;
import com.loki.customer.dto.CustomerGroupDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerGroupMapper extends GenericMapper<CustomerGroupDTO, CustomerGroupEntity> {

}