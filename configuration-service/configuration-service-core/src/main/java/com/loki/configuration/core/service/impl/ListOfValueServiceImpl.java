package com.loki.configuration.core.service.impl;

import com.loki.common.service.impl.GenericService;
import com.loki.configuration.core.entity.ListOfValueEntity;
import com.loki.configuration.dto.ListOfValueDTO;
import com.loki.configuration.core.mapper.ListOfValueMapper;
import com.loki.configuration.core.repository.ListOfValueEntityRepository;
import com.loki.configuration.core.service.ListOfValueService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class ListOfValueServiceImpl extends GenericService<ListOfValueDTO, ListOfValueEntity, Long> implements ListOfValueService {

    private ListOfValueEntityRepository repository;

    private ListOfValueMapper mapper;

    public ListOfValueServiceImpl(ListOfValueEntityRepository repository, ListOfValueMapper mapper) {
        super(repository, mapper);
    }
}