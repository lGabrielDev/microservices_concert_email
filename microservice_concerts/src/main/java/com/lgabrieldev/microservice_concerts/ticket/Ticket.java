package com.lgabrieldev.microservice_concerts.ticket;

import com.lgabrieldev.microservice_concerts.concert.Concert;
import com.lgabrieldev.microservice_concerts.ticket.DTOs.TicketCreateDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_ticket")
public class Ticket {
    
    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String email;


    @ManyToOne(targetEntity = Concert.class)
    @JoinColumn(name = "concert_id", nullable = false)
    private Concert concert;

    //constructors
     public Ticket(TicketCreateDto ticketCreateDto){
        this.email = ticketCreateDto.getEmail();
    }

}
