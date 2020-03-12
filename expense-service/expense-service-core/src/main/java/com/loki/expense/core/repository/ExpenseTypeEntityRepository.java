package com.loki.expense.core.repository;

import com.loki.expense.core.entity.ExpenseTypeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseTypeEntityRepository extends PagingAndSortingRepository<ExpenseTypeEntity, Long> {

}