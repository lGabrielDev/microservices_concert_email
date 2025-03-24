package com.lgabrieldev.microservice_concerts.ticket.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
public class TicketCreateDto {
    
    //attributes
    private String email;
    private Long concertId;
}
