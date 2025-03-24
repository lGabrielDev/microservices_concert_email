package com.lgabrieldev.microservice_concerts.concert;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lgabrieldev.microservice_concerts.concert.DTOs.ConcertCreateDto;
import com.lgabrieldev.microservice_concerts.concert.DTOs.ConcertFullDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("")
@Tag(name = "Concert Controller", description = "")
public class ConcertController {
    
    
    //attributes
    private ConcertService concertService;

    //constructors
    public ConcertController(ConcertService concertService){
        this.concertService = concertService;
    }


    // ----------------------------- POST ----------------------------- 
    @Operation(description = "Create a Concert")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "Concert created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ConcertFullDto.class))),
            @ApiResponse(responseCode = "400", description = "One or more attributes are wrong", content = {@Content(examples = {})})
        }
    )
    @PostMapping("/concert")
    public ResponseEntity<ConcertFullDto> createConcert(@RequestBody ConcertCreateDto concertCreateDto){
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(this.concertService.createConcert(concertCreateDto));
    }
    
    // ----------------------------- GET ALL ----------------------------- 
    @Operation(description = "Get All Concerts")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK"),
        @ApiResponse(responseCode = "400", description = "One or more attributes are wrong", content = {@Content(examples = {})})
    })
    @GetMapping("/concert")
    public ResponseEntity<List<ConcertFullDto>> getAllConcerts(){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.concertService.getAllConcerts());
    }

    // ----------------------------- GET concert by #ID ----------------------------- 
    @Operation(description = "Get a concert by #ID") 
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ConcertFullDto.class))),
        @ApiResponse(responseCode = "400", description = "Concert #ID is wrong!", content = {@Content(examples = {})})
    })
    @GetMapping("/concert/{id}")
    public ResponseEntity<ConcertFullDto> getConcertById(@PathVariable(name = "id") Long id){
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(this.concertService.getConcertById(id));
    }
}