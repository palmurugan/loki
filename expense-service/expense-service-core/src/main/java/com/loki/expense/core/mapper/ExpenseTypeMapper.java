package com.loki.expense.core.mapper;

import com.loki.common.mapper.GenericMapper;
import com.loki.expense.core.entity.ExpenseTypeEntity;
import com.loki.expense.dto.ExpenseTypeDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseTypeMapper extends GenericMapper<ExpenseTypeDTO, ExpenseTypeEntity> {

}