package com.lgabrieldev.microservice_concerts.concert.validations;

import com.lgabrieldev.microservice_concerts.concert.ConcertRepository;
import com.lgabrieldev.microservice_concerts.concert.errors.TitleIsNotUniqueException;
import com.lgabrieldev.microservice_concerts.errors.FieldCannotBeNullException;
import com.lgabrieldev.microservice_concerts.errors.FieldLengthIsWrongException;
import com.lgabrieldev.microservice_concerts.validations.GenericValidations;

public class ConcertTitleValidations {
    
    //title cannot be null
    public static Boolean titleIsNotNull(String title){

        if(GenericValidations.fieldIsNotNull(title) == false){
            throw new FieldCannotBeNullException(String.format("Concert 'title' cannot be NULL!"));
        }
        return true;
    }


    //100 characters max
    public static Boolean titleLengthIsCorrect(String title){

        if(GenericValidations.fieldLengthIsOk(title, 100) == false){
            throw new FieldLengthIsWrongException(String.format("Concert 'title' length is too long... It Must be under than 100 characters"));
        }
        return true;
    }

    //must be UNIQUE
    public static Boolean titleIsUnique(String title, ConcertRepository concertRepository){
        concertRepository.findByTitle(title)
            .ifPresent((a) -> {
                throw new TitleIsNotUniqueException(String.format("Concert 'title' '%s' already exists!", title));
            });

    
        return true;
    }


    //all validations are good 
    public static Boolean allValidationsAreGood(String title, ConcertRepository concertRepository){
        ConcertTitleValidations.titleIsNotNull(title);
        ConcertTitleValidations.titleLengthIsCorrect(title);
        ConcertTitleValidations.titleIsUnique(title, concertRepository);
        return true;
    }
    
}
