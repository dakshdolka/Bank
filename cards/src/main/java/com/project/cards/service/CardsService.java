package com.project.cards.service;

import com.project.cards.dto.CardsDto;
import com.project.cards.model.Card;

public interface CardsService {
    public String saveCard(String mobileNumber);

    public Card fetchCard(String mobileNumber);

    String updateCard(CardsDto cardsDto);

    void deleteCard(String mobileNumber);
}
