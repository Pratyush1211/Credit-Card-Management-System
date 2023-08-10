package com.citi.creditcard.exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StateNotFoundException extends Exception{
    private static final Logger logger = LoggerFactory.getLogger(StateNotFoundException.class);

    public StateException(String message) {
        super(message);
        logger.error(message);
    }
}
