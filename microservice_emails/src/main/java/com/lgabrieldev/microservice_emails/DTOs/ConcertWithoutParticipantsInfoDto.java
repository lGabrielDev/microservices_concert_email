package com.lgabrieldev.microservice_emails.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ConcertWithoutParticipantsInfoDto {
    
    //attributes
    private Long id;
    private String title;
    private String description;
    private String city;
    private String date;

}
