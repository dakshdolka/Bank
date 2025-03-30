package com.project.cards.controller;


import com.project.cards.dto.CardsDto;
import com.project.cards.model.Card;
import com.project.cards.service.CardsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CardsController {

    private CardsService cardService;


    @PostMapping("/card")
    public ResponseEntity<String> saveCard(@RequestParam String mobileNumber){

        return ResponseEntity.ok(cardService.saveCard(mobileNumber));
    }

    @GetMapping("/card")
    public ResponseEntity<Card> fetchCardDetails(@RequestParam String mobileNumber) {

        return ResponseEntity.status(HttpStatus.OK).body(cardService.fetchCard(mobileNumber));
    }

    @PutMapping("/card")
    public ResponseEntity<String> updateCardDetails(@Valid @RequestBody CardsDto cardsDto){

        return ResponseEntity.ok( cardService.updateCard(cardsDto));
    }

    @DeleteMapping("/card")
    public ResponseEntity<String> deleteCard(@Pattern(regexp="(^$|[0-9]{10})", message= "Mobile number should be valid and 10 digits long.") @RequestParam String mobileNumber){
        return ResponseEntity.ok("Card deleted successfully");
    }
}
