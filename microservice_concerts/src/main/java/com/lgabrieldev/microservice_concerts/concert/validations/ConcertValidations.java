package com.lgabrieldev.microservice_concerts.concert.validations;

import com.lgabrieldev.microservice_concerts.concert.ConcertRepository;
import com.lgabrieldev.microservice_concerts.concert.DTOs.ConcertCreateDto;

public class ConcertValidations {
    

    //title validations
    public static Boolean titleIsOk(String title, ConcertRepository concertRepository){
       return ConcertTitleValidations.allValidationsAreGood(title, concertRepository);
    }

    //description validations
    public static Boolean descriptionIsOk(String description){
        return ConcertDescriptionValidations.allValidationsAreGood(description);
    }
     
    //city validations
    public static Boolean cityIsOk(String city){
        return ConcertCityValidations.allValidationsAreGood(city);
    }

    //date validations
    public static Boolean dateIsOk(String city){
        return ConcertDateValidations.allValidationsAreGood(city);
    }


    //maxParticipants validations
    public static Boolean maxParticipantsIsOk(Integer maxParticipants){
        return ConcertMaxParticipantsValidations.allValidationsAreGood(maxParticipants);
    }

    public static Boolean allAttributesAreCorrect(ConcertCreateDto concertDto, ConcertRepository concertRepository){
        ConcertValidations.titleIsOk(concertDto.getTitle(), concertRepository);
        ConcertValidations.descriptionIsOk(concertDto.getDescription());
        ConcertValidations.cityIsOk(concertDto.getCity());
        ConcertValidations.dateIsOk(concertDto.getDate());
        ConcertValidations.maxParticipantsIsOk(concertDto.getMaxParticipants());
        return true;
    }


    
}
