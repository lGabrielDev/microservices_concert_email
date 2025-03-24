package com.lgabrieldev.microservice_concerts.ticket.errors;

public class EmailAlreadyRegisteredInConcertException extends RuntimeException {

    //constructors
    public EmailAlreadyRegisteredInConcertException(String errorMessage){
        super(errorMessage);
    }
}