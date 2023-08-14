package com.citi.creditcard.exceptions;

import com.citi.creditcard.utility.ErrorResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.BindException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TransactionsNotFoundException.class)
    public ResponseEntity<Object> handleTransactionNotFound( TransactionsNotFoundException e) {
        return ErrorResponseHandler.generateResponse(e, HttpStatus.NOT_FOUND, new Object[0]);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleInvalidPathVariable( IllegalArgumentException e) {
        return ErrorResponseHandler.generateResponse(e, HttpStatus.BAD_REQUEST, null);

    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<Object> handleCustomerAlreadyExists( CustomerAlreadyExistsException e) {
        return ErrorResponseHandler.generateResponse(e, HttpStatus.BAD_REQUEST, null);
    }

}


