package com.citi.creditcard.exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerAlreadyExistsException extends RuntimeException{
    private static final Logger logger = LoggerFactory.getLogger(CustomerAlreadyExistsException.class);

    public CustomerAlreadyExistsException(String message){
        super(message);
        logger.error(message);
    }
}
