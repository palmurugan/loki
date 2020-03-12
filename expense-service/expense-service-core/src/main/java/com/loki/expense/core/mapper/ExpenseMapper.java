package com.loki.expense.core.mapper;

import com.loki.common.mapper.GenericMapper;
import com.loki.expense.core.entity.ExpenseEntity;
import com.loki.expense.dto.ExpenseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpenseMapper extends GenericMapper<ExpenseDTO, ExpenseEntity> {

}