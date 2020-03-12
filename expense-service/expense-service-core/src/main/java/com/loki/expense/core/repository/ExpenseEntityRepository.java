package com.loki.expense.core.repository;

import com.loki.expense.core.entity.ExpenseEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseEntityRepository extends PagingAndSortingRepository<ExpenseEntity, Long> {

}