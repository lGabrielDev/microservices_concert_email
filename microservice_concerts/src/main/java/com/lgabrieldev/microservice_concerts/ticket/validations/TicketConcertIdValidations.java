package com.lgabrieldev.microservice_concerts.ticket.validations;

import java.util.Set;
import com.lgabrieldev.microservice_concerts.concert.Concert;
import com.lgabrieldev.microservice_concerts.concert.ConcertRepository;
import com.lgabrieldev.microservice_concerts.concert.errors.ConcertIsFullException;
import com.lgabrieldev.microservice_concerts.errors.FieldCannotBeNullException;
import com.lgabrieldev.microservice_concerts.ticket.Ticket;
import com.lgabrieldev.microservice_concerts.ticket.errors.ConcertIdIsWrongException;
import com.lgabrieldev.microservice_concerts.ticket.errors.EmailAlreadyRegisteredInConcertException;
import com.lgabrieldev.microservice_concerts.validations.GenericValidations;

public class TicketConcertIdValidations {
 
    //cannot be null
    public static Boolean ticketConcertIdIsNotNull(Long concertId){
        if(GenericValidations.fieldIsNotNull(concertId) == false){
            throw new FieldCannotBeNullException(String.format(" 'concertId' cannot be NULL!"));
        }
        return true;
    }

    //concert #ID must exists
    public static Boolean ticketConcertIdExists(Long concertId, ConcertRepository concertRepository){
        
        concertRepository.findById(concertId)
            .orElseThrow(() -> {
                throw new ConcertIdIsWrongException(String.format("concert #%d does not exists!", concertId));
            });

        return true;
    }

    //concert is not full
    public static Boolean ticketConcertIsNotFull(Long concertId, ConcertRepository concertRepository){

        Concert concert = concertRepository.findById(concertId)
        .orElseThrow(() -> {
            throw new ConcertIdIsWrongException(String.format("concert #%d does not exists!", concertId));
        });
        
        if(concert.getCurrentParticipants() == concert.getMaxParticipants()){
            throw new ConcertIsFullException(String.format("Concert #%d is full!", concertId));
        }

        return true;
    }

    //email already registered in concert
    public static Boolean emailAlreadyRegisteredInConcert(Long concertId, ConcertRepository concertRepository, String email){

        Concert concert = concertRepository.findById(concertId)
        .orElseThrow(() -> {
            throw new ConcertIdIsWrongException(String.format("concert #%d does not exists!", concertId));
        });

        Set<Ticket> concertTickets = concert.getTickets();

        Boolean emailAlreadyExists = concertTickets.stream()
            .map(ticket -> ticket.getEmail())
            .anyMatch(ticketEmail -> ticketEmail.equals(email));

        if(emailAlreadyExists){
            throw new EmailAlreadyRegisteredInConcertException(String.format(" The email '%s' has already purchased a ticket for this concert.", email));
        }
        return true;

    }
    
    public static Boolean allValidationsAreGood(Long concertId, ConcertRepository concertRepository, String email){
        TicketConcertIdValidations.ticketConcertIdIsNotNull(concertId);
        TicketConcertIdValidations.ticketConcertIdExists(concertId, concertRepository);
        TicketConcertIdValidations.ticketConcertIsNotFull(concertId, concertRepository);
        TicketConcertIdValidations.emailAlreadyRegisteredInConcert(concertId, concertRepository, email);
        return true;
    }
}