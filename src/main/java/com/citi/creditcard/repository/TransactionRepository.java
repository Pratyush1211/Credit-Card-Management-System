package com.citi.creditcard.repository;

import com.citi.creditcard.entity.Transaction;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;


import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, Integer> {


    @Aggregation(pipeline = {
            "{$group: {_id: '$merchant'}}",
            "{$sort: {_id: 1}}"
    })
    List<String> findDistinctMerchantValues();


    Page<Transaction> findByMerchant(String merchant, Pageable pageable);


    Page<Transaction> findByCity(String city, Pageable pageable);

    @Aggregation(pipeline = {
            "{$group: {_id: '$city'}}",
            "{$sort: {_id: 1}}"
    })
    List<String> findDistinctCityValues();

    Page<Transaction> findByState(String state, Pageable pageable);

    @Aggregation(pipeline = {
            "{$group: {_id: '$state'}}",
            "{$sort: {_id: 1}}"
    })
    List<String> findDistinctStateValues();

    @Query("{'amt' : {$gte : ?0, $lte : ?1}}")
    List<Transaction> findByAmount(double low, double high);


    Page<Transaction> findByGender(String gender, Pageable pageable);

    @Aggregation(pipeline = {
            "{$group: {_id: '$category'}}",
            "{$sort: {_id: 1}}"
    })
    List<String> findDistinctSpendingCategories();

    Page<Transaction> findByCategory(String category, Pageable pageable);



}
