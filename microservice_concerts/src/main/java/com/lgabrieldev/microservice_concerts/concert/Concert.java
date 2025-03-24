package com.lgabrieldev.microservice_concerts.concert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import com.lgabrieldev.microservice_concerts.concert.DTOs.ConcertCreateDto;
import com.lgabrieldev.microservice_concerts.ticket.Ticket;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_concert")
public class Concert {
    
    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 100)
    private String description;
    
    @Column(length = 100, nullable = false)
    private String city;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private int maxParticipants;

    @OneToMany(mappedBy = "concert")
    Set<Ticket> tickets;


    //constructors
    public Concert(ConcertCreateDto concertCreateDto){
        this.title = concertCreateDto.getTitle();
        this.description = concertCreateDto.getDescription();
        this.city = concertCreateDto.getCity();

        DateTimeFormatter brFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.date = LocalDate.parse(concertCreateDto.getDate(), brFormat);


        this.maxParticipants = concertCreateDto.getMaxParticipants();

        this.tickets = new HashSet<>();
    }


    //getters and setters


    //currentParticipants;
    public Integer getCurrentParticipants(){
        return this.tickets.size();
    }


}
