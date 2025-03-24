package com.lgabrieldev.microservice_concerts.swagger;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {
    

    @Bean
    public OpenAPI startUpSwagger(){
        return new OpenAPI()
            .info(
                new Info().title("Concert Microservice").description("Designed to manage musical events")
                    .license(
                        new License().name("MIT").url("https://opensource.org/license/mit")
                    )
                    .contact(
                        new Contact().email("thegabrielfreitasbf@yahoo.com.br").name("lGabrielDev")
                    )
                    .version("50.4")
            )
            .servers(
                List.of(
                    new Server().url("http://localhost:8080")
                    .description("Concert Microservice")
                )
            );
            //tags.... etc....
    }
}
