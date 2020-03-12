package com.loki.expense.impl.service.impl;

import com.loki.expense.impl.service.ExpenseTypeServiceExt;
import com.loki.expense.impl.repository.ExpenseTypeEntityRepositoryExt;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ExpenseTypeServiceImplExt implements ExpenseTypeServiceExt {

    private ExpenseTypeEntityRepositoryExt repository;

    @Inject
    public ExpenseTypeServiceImplExt(ExpenseTypeEntityRepositoryExt repository) {
        this.repository = repository;
    }
}