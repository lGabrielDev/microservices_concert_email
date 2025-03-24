package com.lgabrieldev.microservice_concerts.ticket.validations;

import com.lgabrieldev.microservice_concerts.errors.FieldCannotBeNullException;
import com.lgabrieldev.microservice_concerts.errors.FieldLengthIsWrongException;
import com.lgabrieldev.microservice_concerts.ticket.errors.EmailIsWrongException;
import com.lgabrieldev.microservice_concerts.validations.GenericValidations;

public class TicketEmailValidations {
    
    //cannot be null
    public static Boolean ticketEmailIsNotNull(String email){
        if(GenericValidations.fieldIsNotNull(email) == false){
            throw new FieldCannotBeNullException(String.format("Ticket 'email' cannot be NULL!"));
        }
        return true;

    }

    //100 characters max
    public static Boolean emailLengthIsCorrect(String email){

        if(GenericValidations.fieldLengthIsOk(email, 100) == false){
            throw new FieldLengthIsWrongException(String.format("Ticket email length is too long... It Must be under than 100 characters"));
        }
        return true;
    }

    // ============ email characters  ============
    //should contains '@'
    public static Boolean emailContainsAtsymbol(String email){
        if(!(email.contains("@"))){
            throw new EmailIsWrongException("email does not contains '@' ");
        }
        return true;
    }

    //only one '@'
    public static Boolean emailContainsOnlyOneAtSymbol(String email){

        Long atSymbols = email.chars()
            .filter(currenctCharacter -> currenctCharacter == '@')
            .count();

        if(atSymbols > 1){
            throw new EmailIsWrongException("email is wrong! It must have only one '@' ");
        }
        return true;
    }

    //ends with '.com' or '.br'
    public static Boolean emailEndsWithDotComOrDotBr(String email){

        if(email.endsWith(".com") || email.endsWith(".br")){
            return true;
        }
        throw new EmailIsWrongException("email is wrong! It must ends with '.com' OR '.br' ");
    }

    //There must be at least one character before and after '@'.
    public static Boolean beforeAndAfterAtSymbolContainsSomething(String email){

        Integer atIndex = email.indexOf('@');
        
        Integer dotComOrBr = -1;

        if(email.endsWith(".com")){
            dotComOrBr = email.indexOf(".com");
        }
        if(email.endsWith(".br")){
            dotComOrBr = email.indexOf(".br");
        }
 
        String domainPart = email.substring(atIndex + 1, dotComOrBr);

        if(atIndex == 0){
            throw new EmailIsWrongException("email is wrong! It must contains at least one character before '@' ");
        }

        if(domainPart.length() == 0){
            throw new EmailIsWrongException("email is wrong! It must contains at least one between '@' and '.com' ");
        }
        return true;
    }

    //all validations are good 
    public static Boolean allValidationsAreGood(String email){
        TicketEmailValidations.ticketEmailIsNotNull(email);
        TicketEmailValidations.emailLengthIsCorrect(email);
        //symbols
        TicketEmailValidations.emailContainsAtsymbol(email);
        TicketEmailValidations.emailContainsOnlyOneAtSymbol(email);
        TicketEmailValidations.emailEndsWithDotComOrDotBr(email);
        TicketEmailValidations.beforeAndAfterAtSymbolContainsSomething(email);
        return true;
    }
}
