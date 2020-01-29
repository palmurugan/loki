package com.loki.configuration.impl.service.impl;

import com.loki.configuration.impl.service.ListOfValueTypeServiceExt;
import com.loki.configuration.impl.repository.ListOfValueTypeEntityRepositoryExt;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ListOfValueTypeServiceImplExt implements ListOfValueTypeServiceExt {

    private ListOfValueTypeEntityRepositoryExt repository;

    @Inject
    public ListOfValueTypeServiceImplExt(ListOfValueTypeEntityRepositoryExt repository) {
        this.repository = repository;
    }
}