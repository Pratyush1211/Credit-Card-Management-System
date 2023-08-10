package com.citi.creditcard.repository;

import com.citi.creditcard.entity.Transaction;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, Long> {

    @Query(value = "{merchant:  '?0'}")
    List<Transaction> findAll(String merchant);


}
