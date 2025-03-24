package com.lgabrieldev.microservice_concerts.concert.errors;

public class ConcertIsFullException extends RuntimeException {
    
    //constructors
    public ConcertIsFullException(String errorMessage){
        super(errorMessage);
    }
}