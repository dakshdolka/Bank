package com.project.cards.model;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "cards")
public class Card extends BaseEntity{
    private String cardNumber;

    private String mobileNumber;

    private String cardType;

    private Integer totalLimit;

    private Integer amountUsed;

    private Integer availableAmount;
}
