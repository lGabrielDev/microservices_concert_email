package com.lgabrieldev.microservice_concerts.concert.errors;

public class MaxParticipantsIsWrongException extends RuntimeException {
    
    //constructors
    public MaxParticipantsIsWrongException(String errorMessage){
        super(errorMessage);
    }
}