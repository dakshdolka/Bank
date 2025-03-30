package com.project.cards.repository;

import com.project.cards.model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CardRepository extends MongoRepository<Card, String> {
    Optional<Card> findByMobileNumber(String mobileNumber);
}
