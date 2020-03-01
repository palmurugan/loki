package com.loki.customer.core.web.validator;

import com.loki.common.validator.GenericValidator;
import com.loki.common.validator.ValidatorUtil;
import com.loki.customer.core.web.exception.CustomerValiadtionException;
import com.loki.customer.dto.CustomerDTO;
import org.springframework.stereotype.Component;

/**
 * @author palmurugan
 */
@Component
public class CustomerValidator implements GenericValidator<CustomerDTO> {

    @Override
    public void validate(CustomerDTO customerDTO) {
        StringBuilder errorFields = new StringBuilder();

        errorFields.append(ValidatorUtil.testValue().test(customerDTO.getFirstName())
                .getFieldErrorIfInValid("Please specify valid firstName").orElse(""));

        String errors = errorFields.toString();
        if (!errors.isEmpty()) {
            throw new CustomerValiadtionException(errors);
        }
    }
}
