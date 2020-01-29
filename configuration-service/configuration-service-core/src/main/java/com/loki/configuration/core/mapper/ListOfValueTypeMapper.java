package com.loki.configuration.core.mapper;

import com.loki.common.mapper.GenericMapper;
import com.loki.configuration.core.entity.ListOfValueTypeEntity;
import com.loki.configuration.dto.ListOfValueTypeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ListOfValueTypeMapper extends GenericMapper<ListOfValueTypeDTO, ListOfValueTypeEntity> {

}