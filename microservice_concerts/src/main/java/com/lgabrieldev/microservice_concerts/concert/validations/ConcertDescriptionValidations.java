package com.lgabrieldev.microservice_concerts.concert.validations;

import com.lgabrieldev.microservice_concerts.errors.FieldCannotBeNullException;
import com.lgabrieldev.microservice_concerts.errors.FieldLengthIsWrongException;
import com.lgabrieldev.microservice_concerts.validations.GenericValidations;

public class ConcertDescriptionValidations {
    
    //description cannot be null
    public static Boolean descriptionIsNotNull(String description){

        if(GenericValidations.fieldIsNotNull(description) == false){
            throw new FieldCannotBeNullException(String.format("Concert description cannot be NULL!"));
        }
        return true;
    }


    //100 characters max
    public static Boolean descriptionLengthIsCorrect(String description){

        if(GenericValidations.fieldLengthIsOk(description, 100) == false){
            throw new FieldLengthIsWrongException(String.format("Concert description length is too long... It Must be under than 100 characters"));
        }
        return true;
    }

    //all validations are good 
    public static Boolean allValidationsAreGood(String description){
        ConcertDescriptionValidations.descriptionIsNotNull(description);
        ConcertDescriptionValidations.descriptionLengthIsCorrect(description);
        return true;
    }
}
