package com.barclays.assessment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/*
Author : Atul Kumar
*/
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Account or Product not found")
public class AccountProductException extends Exception {

    public AccountProductException(){
        super();
    }

    public AccountProductException(String message){
        super(message);
    }

}
