package com.loki.item.core.mapper;

import com.loki.common.mapper.GenericMapper;
import com.loki.item.core.entity.ItemCategoryEntity;
import com.loki.item.dto.ItemCategoryDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemCategoryMapper extends GenericMapper<ItemCategoryDTO, ItemCategoryEntity> {

}