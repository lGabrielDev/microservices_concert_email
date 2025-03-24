package com.lgabrieldev.microservice_emails.errors;

public class FileDoesNotExistsException extends RuntimeException {
    
    //constructors
    public FileDoesNotExistsException(String errorMessage){
        super(errorMessage);
    }
}
