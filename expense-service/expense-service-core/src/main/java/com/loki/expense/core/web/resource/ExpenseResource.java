package com.loki.expense.core.web.resource;

import com.loki.common.web.resource.BaseRestResource;
import com.loki.expense.dto.ExpenseDTO;
import com.loki.expense.core.service.ExpenseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/expense")
public class ExpenseResource extends BaseRestResource<ExpenseDTO, Long> {

    private ExpenseService service;

    @Inject
    public ExpenseResource(ExpenseService service) {
        super(service, null);
    }
}