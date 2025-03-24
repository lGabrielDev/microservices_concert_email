package com.lgabrieldev.microservice_concerts.ticket.validations;

public class TicketIdIsWrongException extends RuntimeException{
    
    //constructors
    public TicketIdIsWrongException(String errorMessage){
        super(errorMessage);
    }

}
