package com.project.loans.repository;

import com.project.loans.model.Loan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface LoansRepository extends MongoRepository<Loan,String> {
    Optional<Loan> findByMobileNumber(String mobileNumber);
}
