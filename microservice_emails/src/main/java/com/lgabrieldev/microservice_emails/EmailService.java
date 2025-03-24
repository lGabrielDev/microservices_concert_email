package com.lgabrieldev.microservice_emails;

import java.io.File;
import java.io.IOException;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.lgabrieldev.microservice_emails.DTOs.EmailDto;
import com.lgabrieldev.microservice_emails.DTOs.TicketFullDto;
import com.lgabrieldev.microservice_emails.files.CheckFiles;
import com.lgabrieldev.microservice_emails.files.HtmlHandle;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    //attributes
    private JavaMailSender mailSender;
    private EmailDto email;

    //constructors
    public EmailService(JavaMailSender mailSender, EmailDto email){
        this.mailSender = mailSender;
        this.email = email;
    }

    //POST
        public String sendEmail(@RequestBody TicketFullDto ticketFullDto)  throws MessagingException, IOException{
        
            

        System.out.println("\n\n\n\n\n\n============================\n\n\n");

        System.out.println(ticketFullDto.getId());
        System.out.println(ticketFullDto.getEmail());
        System.out.println(ticketFullDto.getConcert().getCity());
        System.out.println(ticketFullDto.getConcert().getTitle());
        System.out.println(ticketFullDto.getConcert().getDescription());
        System.out.println(ticketFullDto.getConcert().getDate());


        MimeMessage message = this.mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true); //'true' to allow us to send attachments

        
        CheckFiles.fileExists(email.getHTML_TEMPLATE_PATH());
        CheckFiles.fileExists(email.getPDF_PATH());
        

        this.email.setEMAIL_TO(ticketFullDto.getEmail());
        messageHelper.setTo(email.getEMAIL_TO());
        messageHelper.setSubject(email.getSUBJECT());
        messageHelper.setFrom(email.getFROM());
        messageHelper.addAttachment("ticket.pdf", new File(email.getPDF_PATH()));


        String htmlEdited = HtmlHandle.replaceValues(email.getBody(), ticketFullDto);
        messageHelper.setText(htmlEdited, true);
        this.mailSender.send(message);

        return "Email sent successfully!!!";
    }
}