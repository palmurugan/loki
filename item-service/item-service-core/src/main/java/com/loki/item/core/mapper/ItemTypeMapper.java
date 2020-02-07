package com.loki.item.core.mapper;

import com.loki.common.mapper.GenericMapper;
import com.loki.item.core.entity.ItemTypeEntity;
import com.loki.item.dto.ItemTypeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemTypeMapper extends GenericMapper<ItemTypeDTO, ItemTypeEntity> {

}