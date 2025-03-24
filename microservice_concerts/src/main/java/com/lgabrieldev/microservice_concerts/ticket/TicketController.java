package com.lgabrieldev.microservice_concerts.ticket;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lgabrieldev.microservice_concerts.ticket.DTOs.TicketCreateDto;
import com.lgabrieldev.microservice_concerts.ticket.DTOs.TicketFullDto;
import com.lgabrieldev.microservice_concerts.ticket.DTOs.TicketOnlyIdAndEmailDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("")
@Tag(name = "Ticket Controller", description = "")
public class TicketController {
    
    //attributes
    private TicketService ticketService;

    //constructors
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }


    // ----------------------------- POST ----------------------------- 
    @Operation(description = "Create a Ticket")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "Ticket created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TicketFullDto.class))),
            @ApiResponse(responseCode = "400", description = "One or more attributes are wrong", content = {@Content(examples = {})})
        }
    )
    @PostMapping("/ticket")
    public ResponseEntity<String> createConcert(@RequestBody TicketCreateDto ticketCreateDto){
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.ticketService.createTicket(ticketCreateDto));
    }
    
    // ----------------------------- GET ALL -----------------------------
  
    @Operation(description = "Get All Tickets")
    @ApiResponses( value = {
          @ApiResponse(responseCode = "200", description = "OK"),
        }
    )
    @GetMapping("/ticket")
    public ResponseEntity<List<TicketOnlyIdAndEmailDto>> getAllTickets(){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.ticketService.getAllTickets());
    }
    
    // ----------------------------- GET ticket by #ID ----------------------------- 
    @Operation(description = "Get Ticket by #ID")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = TicketFullDto.class))),
            @ApiResponse(responseCode = "400", description = "Ticket #ID not found!", content = {@Content(examples = {})})
        }
    )
    @GetMapping("/ticket/{id}")
    public ResponseEntity<TicketFullDto> getConcertById(@PathVariable(name = "id") Long id){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.ticketService.getTicketById(id));
    }
}