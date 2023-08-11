package com.citi.creditcard.exceptions;

public class TransactionsNotFoundException extends RuntimeException {
    public TransactionsNotFoundException(String message) {
        super(message);
    }
}


