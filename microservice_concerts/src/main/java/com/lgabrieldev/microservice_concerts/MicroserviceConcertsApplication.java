package com.lgabrieldev.microservice_concerts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceConcertsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConcertsApplication.class, args);
	}
}
