package com.project.cards.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CardControllerAdvicer {

    ResponseEntity<String> handleCardAlreadyExistsException(CardAlreadyExistsException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
