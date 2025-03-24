package com.lgabrieldev.microservice_concerts.ticket;

import java.util.List;
import org.springframework.stereotype.Service;
import com.lgabrieldev.microservice_concerts.concert.Concert;
import com.lgabrieldev.microservice_concerts.concert.ConcertRepository;
import com.lgabrieldev.microservice_concerts.concert.DTOs.conversions.Conversions;
import com.lgabrieldev.microservice_concerts.microserviceEmail.EmailController;
import com.lgabrieldev.microservice_concerts.ticket.DTOs.TicketCreateDto;
import com.lgabrieldev.microservice_concerts.ticket.DTOs.TicketFullDto;
import com.lgabrieldev.microservice_concerts.ticket.DTOs.TicketOnlyIdAndEmailDto;
import com.lgabrieldev.microservice_concerts.ticket.validations.TicketIdIsWrongException;
import com.lgabrieldev.microservice_concerts.ticket.validations.TicketValidations;

@Service
public class TicketService {
    

    //attributes
    private TicketRepository ticketRepository;
    private ConcertRepository concertRepository;
    private EmailController emailController;

    //constructors
    public TicketService(TicketRepository ticketRepository, ConcertRepository concertRepository, EmailController emailController){
        this.ticketRepository = ticketRepository;
        this.concertRepository = concertRepository;
        this.emailController = emailController;
    }


    // ----------------------------- CREATE ----------------------------- 
    public String createTicket(TicketCreateDto ticketCreateDto){
        //validation............
        TicketValidations.allAttributesAreCorrect(ticketCreateDto, this.concertRepository, ticketCreateDto.getEmail());

        Ticket ticket = new Ticket(ticketCreateDto);

        Concert concert = this.concertRepository.findById(ticketCreateDto.getConcertId())
            .orElseThrow(() -> new RuntimeException(String.format("Concert #%d does not exists", ticketCreateDto.getConcertId())));
            
        ticket.setConcert(concert);
        this.ticketRepository.save(ticket);

        return this.emailController.sendEmail(new TicketFullDto(ticket));       
    }
    
    
    // ----------------------------- READ ALL ----------------------------- 
    public List<TicketOnlyIdAndEmailDto> getAllTickets(){
        
       return Conversions.convertTicket(this.ticketRepository.findAll());
    }
    

    // ----------------------------- READ ticket by #ID -----------------------------
    public TicketFullDto getTicketById(Long id){
        //todas as validacoes...... Fazer depois.....
        Ticket ticket = this.ticketRepository.findById(id)
            .orElseThrow(() -> new TicketIdIsWrongException(String.format("Ticket #%d does not exists", id)));
        return new TicketFullDto(ticket);
    }


}
