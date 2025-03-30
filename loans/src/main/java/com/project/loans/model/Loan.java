package com.project.loans.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "loans")
public class Loan extends BaseDocument{
    private String mobileNumber;

    private String loanType;

    private Integer loanAmount;

    private String loanNumber;

    private Integer amountPaid;

    private Integer outstandingAmount;
}
