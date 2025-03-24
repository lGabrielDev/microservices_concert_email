package com.lgabrieldev.microservice_concerts.ticket.errors;

public class ConcertIdIsWrongException extends RuntimeException {

    //constructors
    public ConcertIdIsWrongException(String errorMessage){
        super(errorMessage);
    }
}