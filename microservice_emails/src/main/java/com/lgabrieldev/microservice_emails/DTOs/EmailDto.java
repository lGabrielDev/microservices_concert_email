package com.lgabrieldev.microservice_emails.DTOs;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
public class EmailDto {
    
    //attributes
    @Value("${spring.mail.username}")
    private String FROM;

    private String EMAIL_TO;

    private String SUBJECT = "title zica tal";

    private String HTML_TEMPLATE_PATH = "/app/templates/ticketTemplate.html";
    private String PDF_PATH = "/app/templates/ticketTemplate.html";

    private String body;

        //constructors
    public EmailDto() throws Exception{
        this.body = new String(Files.readAllBytes(Paths.get(this.HTML_TEMPLATE_PATH)), StandardCharsets.UTF_8);
    }

}
