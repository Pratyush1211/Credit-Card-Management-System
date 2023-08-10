package com.citi.creditcard.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpendingCategoryException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(SpendingCategoryException.class);

    public SpendingCategoryException(String message) {
        super(message);
        logger.error(message);
    }
}
