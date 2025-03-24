package com.lgabrieldev.microservice_concerts.concert.DTOs.conversions;

import java.util.ArrayList;
import java.util.List;

import com.lgabrieldev.microservice_concerts.concert.Concert;
import com.lgabrieldev.microservice_concerts.concert.DTOs.ConcertFullDto;
import com.lgabrieldev.microservice_concerts.ticket.Ticket;
import com.lgabrieldev.microservice_concerts.ticket.DTOs.TicketOnlyIdAndEmailDto;


public abstract class Conversions {
    

    public static List<ConcertFullDto> convertConcert(List<Concert> concerts){
        List<ConcertFullDto> concertFullDtos = new ArrayList<>();
        concerts.stream().forEach((concert) -> concertFullDtos.add(new ConcertFullDto(concert)));
        return concertFullDtos;
    }

    public static List<TicketOnlyIdAndEmailDto> convertTicket(List<Ticket> tickets){
        List<TicketOnlyIdAndEmailDto> ticketFullDtos = new ArrayList<>();
        tickets.stream().forEach((ticket) -> ticketFullDtos.add(new TicketOnlyIdAndEmailDto(ticket)));
        return ticketFullDtos;
    }
}
