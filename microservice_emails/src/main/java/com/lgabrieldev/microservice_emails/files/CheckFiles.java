package com.lgabrieldev.microservice_emails.files;

import java.io.File;
import com.lgabrieldev.microservice_emails.errors.FileDoesNotExistsException;

public class CheckFiles {
    
    public static Boolean fileExists(String filePath){
        File fileToCheck;
        fileToCheck = new File(filePath);

        if(!(fileToCheck.exists())){
            throw new FileDoesNotExistsException(String.format("Microservice_email exception --> File '%s'  not found!", filePath));
        }
        return true;   
    }
}