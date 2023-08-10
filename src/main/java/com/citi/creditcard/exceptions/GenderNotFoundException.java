package com.citi.creditcard.exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenderNotFoundException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(GenderNotFoundException.class);

    public GenderNotFoundException(String message) {
        super(message);
        logger.error(message);
    }
}

