package com.loki.item.core.mapper;

import com.loki.common.mapper.GenericMapper;
import com.loki.item.core.entity.ItemPriceEntity;
import com.loki.item.dto.ItemPriceDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemPriceMapper extends GenericMapper<ItemPriceDTO, ItemPriceEntity> {

}