package com.project.loans.dto;


import lombok.Data;

@Data
public class LoanDto {
    private String mobileNumber;

    private String loanType;

    private Integer loanAmount;

    private String loanNumber;

    private Integer amountPaid;

    private Integer outstandingAmount;
}
