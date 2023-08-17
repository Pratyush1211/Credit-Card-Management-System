package com.citi.creditcard.exceptions;

import com.citi.creditcard.utility.ErrorResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(TransactionsNotFoundException.class)
    public ResponseEntity<Object> handleTransactionNotFound( TransactionsNotFoundException e) {
        logger.error("TransactionsNotFoundException caught: {}", e.getMessage());
        return ErrorResponseHandler.generateResponse(e, HttpStatus.NOT_FOUND, new Object[0]);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleInvalidPathVariable( IllegalArgumentException e) {
        logger.error("IllegalArgumentException caught: {}", e.getMessage());
        return ErrorResponseHandler.generateResponse(e, HttpStatus.BAD_REQUEST, null);

    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<Object> handleCustomerAlreadyExists( CustomerAlreadyExistsException e) {
        logger.error("CustomerAlreadyExistsException caught: {}", e.getMessage());
        return ErrorResponseHandler.generateResponse(e, HttpStatus.BAD_REQUEST, null);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Object> handleCustomerNotFound( CustomerNotFoundException e) {
        logger.error("CustomerNotFoundException caught: {}", e.getMessage());
        return ErrorResponseHandler.generateResponse(e, HttpStatus.BAD_REQUEST, null);
    }

}


