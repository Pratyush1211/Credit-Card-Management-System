package com.citi.creditcard.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpendingAmountException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(SpendingAmountException.class);

    public SpendingAmountException(String message) {
        super(message);
        logger.error(message);
    }
}
