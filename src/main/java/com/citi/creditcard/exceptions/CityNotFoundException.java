package com.citi.creditcard.exceptions;

public class CityNotFoundException extends Exception {
    CityNotFoundException(){
        super();
    }

    CityNotFoundException(String message){
        super(message);
    }


}
