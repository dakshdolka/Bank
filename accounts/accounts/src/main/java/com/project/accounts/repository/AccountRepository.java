package com.project.accounts.repository;

import com.project.accounts.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    Optional<Account> findByCustomerId(String customerId);

    @Transactional
    void deleteByCustomerId(String customerId);

}
