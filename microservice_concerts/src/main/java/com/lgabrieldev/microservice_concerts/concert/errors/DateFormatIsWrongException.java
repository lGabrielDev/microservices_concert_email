package com.lgabrieldev.microservice_concerts.concert.errors;

public class DateFormatIsWrongException extends RuntimeException {
    
    //constructors
    public DateFormatIsWrongException(String errorMessage){
        super(errorMessage);
    }
}
