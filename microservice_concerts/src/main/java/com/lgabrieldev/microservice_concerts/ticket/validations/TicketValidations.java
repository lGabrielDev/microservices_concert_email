package com.lgabrieldev.microservice_concerts.ticket.validations;

import com.lgabrieldev.microservice_concerts.concert.ConcertRepository;
import com.lgabrieldev.microservice_concerts.ticket.DTOs.TicketCreateDto;

public class TicketValidations {
    

    //email validations
    public static Boolean emailIsOk(String email){
        return TicketEmailValidations.allValidationsAreGood(email);
    }
 
    //concertId validations
     public static Boolean concertIsOk(Long concertId, ConcertRepository concertRepository, String email){
        return TicketConcertIdValidations.allValidationsAreGood(concertId, concertRepository, email);
    }

    public static Boolean allAttributesAreCorrect(TicketCreateDto ticketCreateDto, ConcertRepository concertRepository, String email){
        TicketValidations.emailIsOk(ticketCreateDto.getEmail());
        TicketValidations.concertIsOk(ticketCreateDto.getConcertId(), concertRepository, email);
        return true;
    }

}
