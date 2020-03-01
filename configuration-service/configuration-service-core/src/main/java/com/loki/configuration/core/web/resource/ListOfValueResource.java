package com.loki.configuration.core.web.resource;

import com.loki.common.web.resource.BaseRestResource;
import com.loki.configuration.dto.ListOfValueDTO;
import com.loki.configuration.core.service.ListOfValueService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(value = "/listofvalue")
public class ListOfValueResource extends BaseRestResource<ListOfValueDTO, Long> {

    private ListOfValueService service;

    @Inject
    public ListOfValueResource(ListOfValueService service) {
        super(service, null);
        this.service = service;
    }

    @RequestMapping(value = "/lists", method = RequestMethod.GET)
    public ResponseEntity<List<ListOfValueDTO>> findLovListByType(@RequestParam String type) {
        return new ResponseEntity<>(service.findLovListByType(type), HttpStatus.OK);
    }
}