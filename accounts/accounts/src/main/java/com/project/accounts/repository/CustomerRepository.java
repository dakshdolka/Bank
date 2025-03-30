package com.project.accounts.repository;

import com.project.accounts.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{
    Optional<Customer> findByPhoneNumber(String phoneNumber);

}
