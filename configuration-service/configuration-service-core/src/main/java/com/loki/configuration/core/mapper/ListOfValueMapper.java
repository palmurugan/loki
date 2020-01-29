package com.loki.configuration.core.mapper;

import com.loki.common.mapper.GenericMapper;
import com.loki.configuration.core.entity.ListOfValueEntity;
import com.loki.configuration.dto.ListOfValueDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ListOfValueMapper extends GenericMapper<ListOfValueDTO, ListOfValueEntity> {

}