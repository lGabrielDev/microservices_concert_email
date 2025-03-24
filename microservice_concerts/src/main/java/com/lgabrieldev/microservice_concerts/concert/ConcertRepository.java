package com.lgabrieldev.microservice_concerts.concert;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import feign.Param;

@Repository
public interface ConcertRepository extends JpaRepository<Concert, Long> {
    
    @Query(value = "SELECT c FROM Concert c WHERE c.title = :title")
    public Optional<Concert> findByTitle(@Param("title") String title);
}
