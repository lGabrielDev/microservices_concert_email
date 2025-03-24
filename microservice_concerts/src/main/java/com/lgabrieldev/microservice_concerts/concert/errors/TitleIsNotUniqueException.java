package com.lgabrieldev.microservice_concerts.concert.errors;

public class TitleIsNotUniqueException extends RuntimeException {

    //constructors
    public TitleIsNotUniqueException(String errorMessage){
        super(errorMessage);
    }
}
