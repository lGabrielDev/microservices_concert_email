package com.lgabrieldev.microservice_concerts.concert;

import java.util.List;
import org.springframework.stereotype.Service;
import com.lgabrieldev.microservice_concerts.concert.DTOs.ConcertCreateDto;
import com.lgabrieldev.microservice_concerts.concert.DTOs.ConcertFullDto;
import com.lgabrieldev.microservice_concerts.concert.DTOs.conversions.Conversions;
import com.lgabrieldev.microservice_concerts.concert.validations.ConcertValidations;
import com.lgabrieldev.microservice_concerts.ticket.errors.ConcertIdIsWrongException;

@Service
public class ConcertService {
    
    //attributes
    private ConcertRepository concertRepository;

    //constructors
    public ConcertService(ConcertRepository concertRepository){
        this.concertRepository = concertRepository;
    }


    // ----------------------------- CREATE ----------------------------- 
    public ConcertFullDto createConcert(ConcertCreateDto concertCreateDto){

        //validations
        ConcertValidations.allAttributesAreCorrect(concertCreateDto, this.concertRepository);

        Concert concert = new Concert(concertCreateDto);

        return new ConcertFullDto(this.concertRepository.save(concert));
    }
    
    // ----------------------------- READ ALL ----------------------------- 
    public List<ConcertFullDto> getAllConcerts(){
        return Conversions.convertConcert(this.concertRepository.findAll());

    }


    // ----------------------------- READ concert by #ID ----------------------------- 
    public ConcertFullDto getConcertById(Long id){
        //todas as validacoes...... Fazer depois.....
        Concert concert = this.concertRepository.findById(id)
            .orElseThrow(() -> new ConcertIdIsWrongException(String.format("Concert #%d does not exists", id)));
        return new ConcertFullDto(concert);
    }

}
