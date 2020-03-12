package com.loki.expense.impl.web.resource;

import com.loki.expense.impl.service.ExpenseTypeServiceExt;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class ExpenseTypeResourceExt {

    private ExpenseTypeServiceExt service;

    @Inject
    public ExpenseTypeResourceExt(ExpenseTypeServiceExt service) {
        this.service = service;
    }
}