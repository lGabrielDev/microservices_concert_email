package com.lgabrieldev.microservice_concerts.concert.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ConcertCreateDto {
    
    //attributes
    private String title;
    private String description;
    private String city;
    private String date;
    private int maxParticipants;
}
