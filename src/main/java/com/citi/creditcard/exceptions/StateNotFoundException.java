package com.citi.creditcard.exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StateNotFoundException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(StateNotFoundException.class);

    public StateNotFoundException(String message) {
        super(message);
        logger.error(message);
    }
}
// Resolved Conflicts


