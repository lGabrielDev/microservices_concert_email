package com.lgabrieldev.microservice_concerts.ticket.DTOs;

import com.lgabrieldev.microservice_concerts.concert.DTOs.ConcertWithoutParticipantsInfoDto;
import com.lgabrieldev.microservice_concerts.ticket.Ticket;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TicketFullDto {
    
    //attributes
    private Long id;
    private String email;
    private ConcertWithoutParticipantsInfoDto concert;
  

    //constructor
    public TicketFullDto(Ticket ticket) {
        this.id = ticket.getId();
        this.email = ticket.getEmail();
        this.concert = new ConcertWithoutParticipantsInfoDto(ticket.getConcert());
    }

}
