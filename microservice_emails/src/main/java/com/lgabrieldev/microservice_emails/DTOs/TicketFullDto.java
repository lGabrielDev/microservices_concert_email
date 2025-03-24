package com.lgabrieldev.microservice_emails.DTOs;

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

}
