package com.citi.creditcard.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PopulationGroupException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(PopulationGroupException.class);

    public PopulationGroupException(String message) {
        super(message);
        logger.error(message);
    }
}
