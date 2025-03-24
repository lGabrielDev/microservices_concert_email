package com.lgabrieldev.microservice_concerts.concert.validations;

import com.lgabrieldev.microservice_concerts.errors.FieldCannotBeNullException;
import com.lgabrieldev.microservice_concerts.errors.FieldLengthIsWrongException;
import com.lgabrieldev.microservice_concerts.validations.GenericValidations;

public class ConcertCityValidations {
    
    //city cannot be null
    public static Boolean cityIsNotNull(String city){

        if(GenericValidations.fieldIsNotNull(city) == false){
            throw new FieldCannotBeNullException(String.format("Concert city cannot be NULL!"));
        }
        return true;
    }


    //100 characters max
    public static Boolean cityLengthIsCorrect(String city){

        if(GenericValidations.fieldLengthIsOk(city, 100) == false){
            throw new FieldLengthIsWrongException(String.format("Concert city length is too long... It Must be under than 100 characters"));
        }
        return true;
    }

    //all validations are good 
    public static Boolean allValidationsAreGood(String city){
        ConcertCityValidations.cityIsNotNull(city);
        ConcertCityValidations.cityLengthIsCorrect(city);
        return true;
    }
}
