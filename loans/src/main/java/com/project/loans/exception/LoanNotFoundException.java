package com.project.loans.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LoanNotFoundException extends  RuntimeException{
    public LoanNotFoundException(String mobileNumber) {
        super("Loan record with mobile number "+mobileNumber+" not found");
    }
}
