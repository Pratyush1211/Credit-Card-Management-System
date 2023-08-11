package com.citi.creditcard.exceptions;


import com.citi.creditcard.entity.ApiErrorResponse;
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
    public ResponseEntity<ApiErrorResponse> handleTransactionNotFoundException(TransactionsNotFoundException e){
        logger.error("TransactionsNotFoundException caught: {}", e.getMessage());
        ApiErrorResponse errorResponse = new ApiErrorResponse("Resource Not Found", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorResponse> handleIllegalArgumentException( IllegalArgumentException e){
        logger.error("IllegalArgumentException caught: {}", e.getMessage());

        ApiErrorResponse errorResponse = new ApiErrorResponse("Field can't be null or empty", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
