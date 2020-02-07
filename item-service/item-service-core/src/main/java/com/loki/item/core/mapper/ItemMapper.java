package com.loki.item.core.mapper;

import com.loki.common.mapper.GenericMapper;
import com.loki.item.core.entity.ItemEntity;
import com.loki.item.dto.ItemDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemMapper extends GenericMapper<ItemDTO, ItemEntity> {

}