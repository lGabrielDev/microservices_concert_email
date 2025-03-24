package com.lgabrieldev.microservice_emails.files;

import com.lgabrieldev.microservice_emails.DTOs.TicketFullDto;

public class HtmlHandle {
    
    public static String replaceValues(String htmlContent, TicketFullDto ticketFullDto){

        return 
            htmlContent
                .replace("${id}", ticketFullDto.getId().toString())
                .replace("${email}", ticketFullDto.getEmail())
                .replace("${show_title}", ticketFullDto.getConcert().getTitle())
                .replace("${show_description}", ticketFullDto.getConcert().getDescription())
                .replace("${city}", ticketFullDto.getConcert().getCity())
                .replace("${date}", ticketFullDto.getConcert().getDate());
    }

}
