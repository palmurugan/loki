package com.loki.expense.impl.web.resource;

import com.loki.expense.impl.service.ExpenseServiceExt;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class ExpenseResourceExt {

    private ExpenseServiceExt service;

    @Inject
    public ExpenseResourceExt(ExpenseServiceExt service) {
        this.service = service;
    }
}