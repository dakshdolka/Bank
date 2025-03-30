package com.project.accounts.controller;


import com.project.accounts.dto.ErrorResponseDto;
import com.project.accounts.exception.AccountNotFoundException;
import com.project.accounts.exception.CustomerExistedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BankControllerAdvice {

    @ExceptionHandler(Exception.class)
    ResponseEntity<ErrorResponseDto> handleGlobalException(Exception ex){
        return new ResponseEntity<>(new ErrorResponseDto(ex.getMessage(), 500), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(CustomerExistedException.class)
    ResponseEntity<ErrorResponseDto> handleCutomerExistedException(CustomerExistedException ex){
        return new ResponseEntity<>(new ErrorResponseDto(ex.getMessage(), 400), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    ResponseEntity<ErrorResponseDto> handleAccountNotFoundException(AccountNotFoundException ex){
        return new ResponseEntity<>(new ErrorResponseDto(ex.getMessage(), 404), HttpStatus.NOT_FOUND);
    }

}
