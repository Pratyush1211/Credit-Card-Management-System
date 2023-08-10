package com.citi.creditcard.exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class MerchantNotFoundException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(MerchantNotFoundException.class);

    public MerchantException(String message) {
        super(message);
        logger.error(message);
    }
}
