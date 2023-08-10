package com.citi.creditcard.repository;

import com.citi.creditcard.entity.Transaction;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Objects;

public interface TransactionRepository extends MongoRepository<Transaction, Long> {

    List<Transaction> findByMerchant(String merchant);
    List<Transaction> findByCity(String city);

    @Aggregation(pipeline = {
            "{$group: {_id: '$city'}}"
    })
    List<String> findDistinctCityValues();

    List<Transaction> findByState(String state);


    @Aggregation(pipeline = {
            "{$group: {_id: '$state'}}"
    })
    List<String> findDistinctStateValues();






}
