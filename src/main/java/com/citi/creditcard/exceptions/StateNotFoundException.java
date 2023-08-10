package com.citi.creditcard.exceptions;

public class StateNotFoundException extends Exception{
    StateNotFoundException(){
        super();
    }

    StateNotFoundException(String message){
        super(message);
    }


}
