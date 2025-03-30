package com.project.accounts.service;


import com.project.accounts.dto.AccountsDto;
import com.project.accounts.dto.CustomersDto;
import com.project.accounts.exception.AccountNotFoundException;
import com.project.accounts.exception.CustomerExistedException;
import com.project.accounts.model.Account;
import com.project.accounts.model.Customer;
import com.project.accounts.repository.AccountRepository;
import com.project.accounts.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    private CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomersDto customerDto) {
        if(customerRepository.findByPhoneNumber(customerDto.getPhoneNumber()).isPresent()){
            throw new CustomerExistedException("Customer already exists with phone number: "+customerDto.getPhoneNumber());
        }
        Customer customer = new Customer();
        customer.setEmail(customerDto.getEmail());
        customer.setName(customerDto.getName());
        customer.setPhoneNumber(customerDto.getPhoneNumber());
        customer = customerRepository.save(customer);
        Account account = createAccountFromCustomer(customer, customerDto);
        accountRepository.save(account);

    }

    @Override
    public CustomersDto fetchCustomer(String phoneNumber) {
        Optional<Customer> customer = customerRepository.findByPhoneNumber(phoneNumber);
        if(customer.isPresent()){
            CustomersDto customersDto = new CustomersDto();
            customersDto.setEmail(customer.get().getEmail());
            customersDto.setName(customer.get().getName());
            customersDto.setPhoneNumber(customer.get().getPhoneNumber());
            Optional<Account> accountOptional = accountRepository.findByCustomerId(customer.get().getId());
            if(accountOptional.isPresent()){
                AccountsDto accountsDto = createAccountsDtoFromAccount(accountOptional.get());
                customersDto.setAccountsDto(accountsDto);
            }
            return customersDto;
        }
        else{
            throw new AccountNotFoundException(phoneNumber);
        }
    }

    @Override
    public Boolean updateCustomer(CustomersDto customersDto) {
        Boolean update = false;
        Optional<Account> accountOptional = accountRepository.findById(customersDto.getAccountsDto().getAccountNumber());
        if(accountOptional.isPresent()){
            Account account = accountOptional.get();
            account.setBranchAddress(customersDto.getBranchAddress());
            account.setAccountType(customersDto.getAccountsDto().getAccountType());
            account.setBranchAddress(customersDto.getBranchAddress());
            accountRepository.save(account);

            update = true;
            Optional<Customer> customerOptional = customerRepository.findById(account.getCustomerId());
            if (customerOptional.isPresent()){
                Customer customer = customerOptional.get();
                customer.setEmail(customersDto.getEmail());
                customer.setName(customersDto.getName());
                customer.setPhoneNumber(customersDto.getPhoneNumber());
                customerRepository.save(customer);
                update = true;
                return update;
            }
            else{
                throw new AccountNotFoundException(customersDto.getPhoneNumber());
            }
        }
        else{
            throw new AccountNotFoundException(customersDto.getAccountsDto().getAccountNumber());
        }
    }

    @Override
    public boolean deleteCustomer(String phoneNumber) {
        Optional<Customer> customerOptional = customerRepository.findByPhoneNumber(phoneNumber);
        if(customerOptional.isPresent()){
            Optional<Account> accountOptional = accountRepository.findByCustomerId(customerOptional.get().getId());
            if(accountOptional.isPresent()){
                accountRepository.deleteByCustomerId(customerOptional.get().getId());
                customerRepository.deleteById(customerOptional.get().getId());
                return true;
            }
            else{
                throw new AccountNotFoundException(phoneNumber);
            }
        }
        return false;
    }

    private Account createAccountFromCustomer(Customer customer, CustomersDto customersDto){
        Account account = new Account(customer.getId(),String.valueOf(new Random().nextInt(100000)),"Savings", customersDto.getBranchAddress());
        return account;
    }

    private AccountsDto createAccountsDtoFromAccount(Account account){
        AccountsDto accountsDto = new AccountsDto(account.getAccountNumber(), account.getAccountType(), account.getBranchAddress().toString());
        return accountsDto;
    }

}
