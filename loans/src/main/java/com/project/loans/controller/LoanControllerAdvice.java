package com.project.loans.controller;

import com.project.loans.exception.LoanNotFoundException;
import com.project.loans.exception.RecordFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class LoanControllerAdvice {
    @ExceptionHandler(RecordFoundException.class)
    public ResponseEntity<String> handleRecordFoundException(RecordFoundException recordFoundException){
        return ResponseEntity.badRequest().body(recordFoundException.getMessage());
    }


    @ExceptionHandler(LoanNotFoundException.class)
    public ResponseEntity<String> handleLoanNotFoundException(LoanNotFoundException loanNotFoundException){
        return ResponseEntity.notFound().build();
    }
}
