package com.loki.configuration.core.service;

import com.loki.common.service.IGenericService;
import com.loki.configuration.dto.ListOfValueDTO;

import java.util.List;

public interface ListOfValueService extends IGenericService<ListOfValueDTO, Long> {

    List<ListOfValueDTO> findLovListByType(String name);

}