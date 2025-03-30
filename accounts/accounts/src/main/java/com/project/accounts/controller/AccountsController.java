package com.project.accounts.controller;

import com.project.accounts.dto.CustomersDto;
import com.project.accounts.service.AccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
@Validated
public class AccountsController {

    private AccountService accountService;

    @PostMapping("/createAccount")
    public ResponseEntity<String> saveCustomer(@Valid @RequestBody CustomersDto customersDto){

        accountService.createAccount(customersDto);
        return ResponseEntity.ok("Account created successfully");
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomersDto> fetchCustomer(@RequestParam
                                                          @Pattern(regexp="(^$|[0-9]{10})", message= "Mobile number should be valid and 10 digits long.")
                                                          String phoneNumber){
        return ResponseEntity.ok(accountService.fetchCustomer(phoneNumber));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAccount(@Valid @RequestBody CustomersDto customersDto){
        boolean updated = accountService.updateCustomer(customersDto);
        if(updated){
        return ResponseEntity.ok("Customer updated successfully");}
        else{
            return ResponseEntity.ok("Failed to update customer details");
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCustomer(@RequestParam
                                                     @Pattern(regexp="(^$|[0-9]{10})", message= "Mobile number should be valid and 10 digits long.")
                                                     String phoneNumber){
        boolean deleted = accountService.deleteCustomer(phoneNumber);
        if(deleted){
            return ResponseEntity.ok("Customer deleted successfully");
        }
        else{
            return ResponseEntity.ok("Failed to delete customer");
        }
    }

    @GetMapping("/dummy")
    public ResponseEntity<List<String>> dummy(){
        return ResponseEntity.ok(Arrays.asList("Hello", "World"));
    }

}
