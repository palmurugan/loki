package com.loki.configuration.impl.service.impl;

import com.loki.configuration.impl.service.ListOfValueServiceExt;
import com.loki.configuration.impl.repository.ListOfValueEntityRepositoryExt;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class ListOfValueServiceImplExt implements ListOfValueServiceExt {

    private ListOfValueEntityRepositoryExt repository;

    @Inject
    public ListOfValueServiceImplExt(ListOfValueEntityRepositoryExt repository) {
        this.repository = repository;
    }
}