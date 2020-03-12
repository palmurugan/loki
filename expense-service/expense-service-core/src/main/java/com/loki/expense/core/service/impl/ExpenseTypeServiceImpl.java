package com.loki.expense.core.service.impl;

import com.loki.common.service.impl.GenericService;
import com.loki.expense.core.entity.ExpenseTypeEntity;
import com.loki.expense.dto.ExpenseTypeDTO;
import com.loki.expense.core.mapper.ExpenseTypeMapper;
import com.loki.expense.core.repository.ExpenseTypeEntityRepository;
import com.loki.expense.core.service.ExpenseTypeService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpenseTypeServiceImpl extends GenericService<ExpenseTypeDTO, ExpenseTypeEntity, Long> implements ExpenseTypeService {

    private ExpenseTypeEntityRepository repository;

    private ExpenseTypeMapper mapper;

    public ExpenseTypeServiceImpl(ExpenseTypeEntityRepository repository, ExpenseTypeMapper mapper) {
        super(repository, mapper);
    }
}