package com.lgabrieldev.microservice_concerts.concert.validations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.lgabrieldev.microservice_concerts.concert.errors.DateInThePastException;
import com.lgabrieldev.microservice_concerts.errors.FieldCannotBeNullException;
import com.lgabrieldev.microservice_concerts.validations.GenericValidations;

public class ConcertDateValidations {

    //date cannot be null
    public static Boolean dateIsNotNull(String date){

        if(GenericValidations.fieldIsNotNull(date) == false){
            throw new FieldCannotBeNullException(String.format("Concert date cannot be NULL!"));
        }
        return true;
    }

    
    //brazilian date format
    public static LocalDate dateFormatIsCorrect(String date){

        DateTimeFormatter brFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return LocalDate.parse(date, brFormat); //it will throw an exception if the date format is incorrect        
    }

    //brazilian date format
    public static Boolean isFutureDate(String date){

        LocalDate today = LocalDate.now();
        LocalDate inputDate = dateFormatIsCorrect(date);

        if((inputDate.isBefore(today))){
            throw new DateInThePastException("Date has passed. Please provide a future date.");
        }

        return true;
    }


    //all validations are good 
    public static Boolean allValidationsAreGood(String date){
        ConcertDateValidations.dateIsNotNull(date);
        ConcertDateValidations.dateFormatIsCorrect(date);
        ConcertDateValidations.isFutureDate(date);
        return true;
    }}
