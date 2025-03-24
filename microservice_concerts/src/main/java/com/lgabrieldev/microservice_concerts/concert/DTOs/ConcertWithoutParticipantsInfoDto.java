package com.lgabrieldev.microservice_concerts.concert.DTOs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.lgabrieldev.microservice_concerts.concert.Concert;
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
    private LocalDate date;

    //constructors
    public ConcertWithoutParticipantsInfoDto(Concert concert){
        this.id = concert.getId();
        this.title = concert.getTitle();
        this.description = concert.getDescription();
        this.city = concert.getCity();
        this.date = concert.getDate();
    }


    //getters and setters
    public String getDate(){
        DateTimeFormatter brFormater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return brFormater.format(this.date);
    }
}
