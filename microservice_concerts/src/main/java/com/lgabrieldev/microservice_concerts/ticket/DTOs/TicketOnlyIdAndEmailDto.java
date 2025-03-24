package com.lgabrieldev.microservice_concerts.ticket.DTOs;

import com.lgabrieldev.microservice_concerts.ticket.Ticket;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TicketOnlyIdAndEmailDto {
    
    //attributes
    private Long id;
    private String email;

    //constructors
    public TicketOnlyIdAndEmailDto(Ticket ticket){
        this.id = ticket.getId();
        this.email = ticket.getEmail();
    }
}
