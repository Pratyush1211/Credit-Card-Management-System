package com.citi.creditcard.repository;

import com.citi.creditcard.entity.Transaction;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, Integer> {

    List<Transaction> findByMerchant(String merchant);
    List<Transaction> findByCity(String city);

    @Aggregation(pipeline = {
            "{$group: {_id: '$city'}}",
            "{$sort: {_id: 1}}"
    })
    List<String> findDistinctCityValues();

    List<Transaction> findByState(String state);

    @Aggregation(pipeline = {
            "{$group: {_id: '$state'}}",
            "{$sort: {_id: 1}}"
    })
    List<String> findDistinctStateValues();






}
