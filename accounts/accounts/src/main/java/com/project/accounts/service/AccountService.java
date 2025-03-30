package com.project.accounts.service;


import com.project.accounts.dto.CustomersDto;

public interface AccountService {
    public void createAccount(CustomersDto customersDto);

    public CustomersDto fetchCustomer(String phoneNumber);

    Boolean updateCustomer(CustomersDto customersDto);

    boolean deleteCustomer(String phoneNumber);
}
