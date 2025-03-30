package com.project.loans.service;


import com.project.loans.dto.LoanDto;
import com.project.loans.exception.LoanNotFoundException;
import com.project.loans.model.Loan;
import com.project.loans.repository.LoansRepository;

import jakarta.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class LoanService {
    @Autowired
    private LoansRepository loansRepository;

    public void createLoan(String mobileNumber){
        Optional<Loan> loanOptional = loansRepository.findByMobileNumber(mobileNumber);
        if(loanOptional.isPresent()){
            throw new RuntimeException("Loan already exists for the mobile number");
        }
        Loan loan = new Loan();
        loan.setLoanNumber(String.valueOf(new Random().nextInt(1000)));
        loan.setLoanAmount(100000);
        loan.setMobileNumber(mobileNumber);
        loan.setLoanType("Personal Loan");
        loan.setAmountPaid(0);
        loan.setOutstandingAmount(100000);
        loansRepository.save(loan);
    }

    public LoanDto getLoanDetails(String mobileNumber) {
        Optional<Loan> loanOptional = loansRepository.findByMobileNumber(mobileNumber);
        if(loanOptional.isPresent()){
            Loan loan = loanOptional.get();
            LoanDto loanDto = new LoanDto();
            loanDto.setLoanNumber(loan.getLoanNumber());
            loanDto.setLoanAmount(loan.getLoanAmount());
            loanDto.setMobileNumber(loan.getMobileNumber());
            loanDto.setLoanType(loan.getLoanType());
            loanDto.setAmountPaid(loan.getAmountPaid());
            loanDto.setOutstandingAmount(loan.getOutstandingAmount());
            return loanDto;
        }
        else{
            throw new LoanNotFoundException(mobileNumber);
        }
    }

    public void updateLoanDetails(LoanDto loanDto) {
        Optional<Loan> loanOptional = loansRepository.findByMobileNumber(loanDto.getMobileNumber());
        // TODO Auto-generated method stub
        if(loanOptional.isPresent()){
            Loan loan = loanOptional.get();
            loan.setAmountPaid(loanDto.getAmountPaid());
            loan.setOutstandingAmount(loan.getLoanAmount()-loanDto.getAmountPaid());
            loansRepository.save(loan);
        }
        else{
            throw new LoanNotFoundException(loanDto.getMobileNumber());
        }
    }

    public void deleteLoan(
            String mobileNumber) {
        // TODO Auto-generated method stub
        Optional<Loan> loanOptional = loansRepository.findByMobileNumber(mobileNumber);
        if(loanOptional.isPresent()){
            loansRepository.delete(loanOptional.get());
        }
        else{
            throw new LoanNotFoundException(mobileNumber);
        }
    }
}
