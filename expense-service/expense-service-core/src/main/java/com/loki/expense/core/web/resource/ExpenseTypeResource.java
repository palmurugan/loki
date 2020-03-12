package com.loki.expense.core.web.resource;

import com.loki.common.web.resource.BaseRestResource;
import com.loki.expense.dto.ExpenseTypeDTO;
import com.loki.expense.core.service.ExpenseTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
@RequestMapping(value = "/expensetype")
public class ExpenseTypeResource extends BaseRestResource<ExpenseTypeDTO, Long> {

    private ExpenseTypeService service;

    @Inject
    public ExpenseTypeResource(ExpenseTypeService service) {
        super(service, null);
    }
}