package com.project.loans.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RecordFoundException extends RuntimeException{
    public RecordFoundException(String mobileNumber) {
        super("Loan record with mobile number "+mobileNumber+" already exists");
    }
}
