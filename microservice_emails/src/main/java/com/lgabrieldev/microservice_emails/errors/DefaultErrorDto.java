package com.lgabrieldev.microservice_emails.errors;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DefaultErrorDto {
    
    //attributes
    private Integer status;
    private String errorMessage;

}
