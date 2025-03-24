package com.lgabrieldev.microservice_concerts.concert.errors;

public class DateInThePastException extends RuntimeException {
    
    //constructors
    public DateInThePastException(String errorMessage){
        super(errorMessage);
    }
}
