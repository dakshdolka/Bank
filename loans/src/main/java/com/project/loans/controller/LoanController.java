package com.project.loans.controller;

import com.project.loans.dto.LoanDto;
import com.project.loans.service.LoanService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/loan")
    public ResponseEntity<String> applyLoan(@Pattern(regexp = "(^$|[0-9]{10})",message = "Please enter valid mobile number")
                                                @RequestParam String mobileNumber){
        loanService.createLoan(mobileNumber);
        return ResponseEntity.ok("Loan applied successfully");
    }

    @GetMapping("/loan")
    public ResponseEntity<LoanDto> getLoanDetails(@Pattern(regexp = "(^$|[0-9]{10})",message = "Please enter valid mobile number")
                                      @RequestParam String mobileNumber){
        return ResponseEntity.ok(loanService.getLoanDetails(mobileNumber));

    }

    @PutMapping("/loan")
    public ResponseEntity<String> updateLoanDetails(@RequestBody LoanDto loanDto){
        loanService.updateLoanDetails(loanDto);
        return ResponseEntity.ok("Loan updated successfully");
    }

    @DeleteMapping("/loan")
    public ResponseEntity<String> deleteLoan(@Pattern(regexp = "(^$|[0-9]{10})",message = "Please enter valid mobile number")
                                                 @RequestParam String mobileNumber){
        loanService.deleteLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
