package com.loki.configuration.core.service.impl;

import com.loki.common.service.impl.GenericService;
import com.loki.configuration.core.entity.ListOfValueTypeEntity;
import com.loki.configuration.dto.ListOfValueTypeDTO;
import com.loki.configuration.core.mapper.ListOfValueTypeMapper;
import com.loki.configuration.core.repository.ListOfValueTypeEntityRepository;
import com.loki.configuration.core.service.ListOfValueTypeService;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class ListOfValueTypeServiceImpl extends GenericService<ListOfValueTypeDTO, ListOfValueTypeEntity, Long> implements ListOfValueTypeService {

    private ListOfValueTypeEntityRepository repository;

    private ListOfValueTypeMapper mapper;

    public ListOfValueTypeServiceImpl(ListOfValueTypeEntityRepository repository, ListOfValueTypeMapper mapper) {
        super(repository, mapper);
    }
}