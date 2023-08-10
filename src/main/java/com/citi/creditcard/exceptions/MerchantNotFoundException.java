package com.citi.creditcard.exceptions;

public class MerchantNotFoundException extends Exception {

    MerchantNotFoundException(){
        super();
    }

    MerchantNotFoundException(String message){
        super(message);
    }



}
