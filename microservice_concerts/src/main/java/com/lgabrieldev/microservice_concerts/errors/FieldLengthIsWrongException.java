package com.lgabrieldev.microservice_concerts.errors;

public class FieldLengthIsWrongException extends RuntimeException {

    //constructors
    public FieldLengthIsWrongException(String errorMessage){
        super(errorMessage);
    }
}
