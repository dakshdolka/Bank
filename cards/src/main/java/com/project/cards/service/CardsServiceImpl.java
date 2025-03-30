package com.project.cards.service;


import com.project.cards.dto.CardsDto;
import com.project.cards.exception.CardAlreadyExistsException;
import com.project.cards.model.Card;
import com.project.cards.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements CardsService{

    private CardRepository cardsRepository;

    @Override
    public String saveCard(String mobileNumber) {
        if(mobileNumber!=null){
            Optional<Card> cardOptional =  cardsRepository.findByMobileNumber(mobileNumber);
            if(cardOptional.isPresent()){
                throw new CardAlreadyExistsException("Card already exists for the mobile number");
            }
            Card newCard = new Card();
            newCard.setMobileNumber(mobileNumber);
            newCard.setCardType("CREDIT_CARD");
            newCard.setCardNumber(String.valueOf(new Random().nextInt(90000000)));
            newCard.setTotalLimit(10000);
            newCard.setAmountUsed(0);
            newCard.setAmountUsed(0);
            cardsRepository.save(newCard);
            return newCard.getCardNumber();
        }
        return null;
    }

    @Override
    public Card fetchCard(String mobileNumber) {
        Card card = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new CardAlreadyExistsException("Card does not exist for the mobile number"));
        return card;
    }

    @Override
    public String updateCard(CardsDto cardsDto) {
        Optional<Card> cardOptional = cardsRepository.findByMobileNumber(cardsDto.getMobileNumber());
        if(!cardOptional.isPresent()){
            throw new CardAlreadyExistsException("Card does not exist for the mobile number");
        }
        Card card = cardOptional.get();
        card.setCardNumber(cardsDto.getCardNumber());
        card.setCardType(cardsDto.getCardType());
        card.setAmountUsed(cardsDto.getAmountUsed());
        card.setTotalLimit(cardsDto.getTotalLimit());
        card.setAvailableAmount(cardsDto.getAvailableAmount());
        card.setMobileNumber(cardsDto.getMobileNumber());
        cardsRepository.save(card);
        return "Successfully updated the card details";
    }

    @Override
    public void deleteCard(String mobileNumber) {
        Optional<Card> cardOptional = cardsRepository.findByMobileNumber(mobileNumber);
        if(!cardOptional.isPresent()){
            throw new CardAlreadyExistsException("Card does not exist for the mobile number");
        }
        cardsRepository.delete(cardOptional.get());
    }
}
