package com.lgabrieldev.microservice_emails;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lgabrieldev.microservice_emails.DTOs.TicketFullDto;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;

@Tag(name = "Email Controller")
@RestController
@RequestMapping("")
public class EmailController {
    
    //attributes
    private EmailService emailService;

    //constructors
    public EmailController(EmailService emailService){
        this.emailService = emailService;
    }

    //POST
    @Operation( description = "Send email")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "Email was sent", content = @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "HTML path or PDF path not found", content = {@Content(examples = {})})
        }
    )
    @PostMapping("/send-email")
    public ResponseEntity<String> sendEmail(@RequestBody TicketFullDto ticketFullDto)  throws MessagingException, IOException{
        return ResponseEntity.status(HttpStatus.CREATED).body(this.emailService.sendEmail(ticketFullDto));
    }
}