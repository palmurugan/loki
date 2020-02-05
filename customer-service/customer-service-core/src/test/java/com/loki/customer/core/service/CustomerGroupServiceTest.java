package com.loki.customer.core.service;

import com.loki.customer.core.repository.CustomerGroupEntityRepository;
import com.loki.customer.dto.CustomerGroupDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.stream.Stream;

@ExtendWith(SpringExtension.class)
public class CustomerGroupServiceTest {

    @Mock
    private CustomerGroupService customerGroupService;

    @Mock
    private CustomerGroupEntityRepository customerGroupEntityRepository;

    @Test
    void contextLoads() {
        System.out.println("Hi I am from Testing..=====");
        System.out.println("=========================================================");
        Stream<CustomerGroupDTO> customerGroupDTOStream = customerGroupService.findAll();
        if(customerGroupDTOStream ==  null) {
            System.out.println("No values====================================================");
        } else  {
            System.out.println("Values Present =======================");
            customerGroupDTOStream.forEach(s -> System.out.println(s.getName()));
        }
        Assertions.assertEquals(1,1);
    }
}
