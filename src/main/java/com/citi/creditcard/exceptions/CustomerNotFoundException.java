package com.citi.creditcard.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerNotFoundException extends RuntimeException{
    private static final Logger logger = LoggerFactory.getLogger(CustomerAlreadyExistsException.class);
    public CustomerNotFoundException(String message){
        super(message);
        logger.error(message);
    }
}
