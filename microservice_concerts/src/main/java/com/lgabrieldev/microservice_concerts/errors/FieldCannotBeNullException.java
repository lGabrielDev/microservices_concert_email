package com.lgabrieldev.microservice_concerts.errors;

public class FieldCannotBeNullException extends RuntimeException {
    
    //constructors
    public FieldCannotBeNullException(String errorMessage){
        super(errorMessage);
    }
    
}
