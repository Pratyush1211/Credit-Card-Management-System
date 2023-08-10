package com.citi.creditcard.repository;

import com.citi.creditcard.entity.Transaction;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, Long> {


}
