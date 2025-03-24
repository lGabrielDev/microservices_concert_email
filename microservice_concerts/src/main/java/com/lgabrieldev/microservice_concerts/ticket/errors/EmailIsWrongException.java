package com.lgabrieldev.microservice_concerts.ticket.errors;

public class EmailIsWrongException extends RuntimeException {

    //constructors
    public EmailIsWrongException(String errorMessage){
        super(errorMessage);
    }
}