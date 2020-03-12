package com.loki.expense.impl.service.impl;

import com.loki.expense.impl.service.ExpenseServiceExt;
import com.loki.expense.impl.repository.ExpenseEntityRepositoryExt;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ExpenseServiceImplExt implements ExpenseServiceExt {

    private ExpenseEntityRepositoryExt repository;

    @Inject
    public ExpenseServiceImplExt(ExpenseEntityRepositoryExt repository) {
        this.repository = repository;
    }
}