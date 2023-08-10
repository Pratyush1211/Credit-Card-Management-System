package com.citi.creditcard.exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class CityNotFoundException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(CityNotFoundException.class);

    CityNotFoundException(String message){

        super(message);
        logger.error(message);
    }



}
