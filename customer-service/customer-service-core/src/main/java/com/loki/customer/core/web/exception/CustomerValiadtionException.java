package com.loki.customer.core.web.exception;

/**
 * @author palmurugan
 */
public class CustomerValiadtionException extends RuntimeException {

    public CustomerValiadtionException(String errorMessage) {
        super(errorMessage);
    }
}
