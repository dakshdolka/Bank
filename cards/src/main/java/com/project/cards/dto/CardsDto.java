package com.project.cards.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardsDto {

    @NotBlank
    private String cardNumber;
    @NotBlank
    private String mobileNumber;

    private String cardType;

    private Integer totalLimit;
    @NotBlank
    private Integer amountUsed;

    private Integer availableAmount;
}
