package com.loki.expense.core.service.impl;

import com.loki.common.service.impl.GenericService;
import com.loki.expense.core.entity.ExpenseEntity;
import com.loki.expense.dto.ExpenseDTO;
import com.loki.expense.core.mapper.ExpenseMapper;
import com.loki.expense.core.repository.ExpenseEntityRepository;
import com.loki.expense.core.service.ExpenseService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpenseServiceImpl extends GenericService<ExpenseDTO, ExpenseEntity, Long> implements ExpenseService {

    private ExpenseEntityRepository repository;

    private ExpenseMapper mapper;

    public ExpenseServiceImpl(ExpenseEntityRepository repository, ExpenseMapper mapper) {
        super(repository, mapper);
    }
}