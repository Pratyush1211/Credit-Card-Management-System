package com.citi.creditcard.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class TransactionsNotFoundException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(CustomerAlreadyExistsException.class);

    public TransactionsNotFoundException(String message) {

        super(message);
        logger.error(message);
    }
}


