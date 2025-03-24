package com.lgabrieldev.microservice_concerts.validations;


public class GenericValidations {
    

    //field cannot be null
    public static Boolean fieldIsNotNull(String field){
        return field != null && !(field.isBlank());
    }

    public static Boolean fieldIsNotNull(Integer field){
        return field != null && field != 0;
    }

    public static Boolean fieldIsNotNull(Long field){
        return field != null;
    }


    //field max characters
    public static Boolean fieldLengthIsOk(String field, Integer maxCharacters){
        return field.length() <= maxCharacters;
    }

}
