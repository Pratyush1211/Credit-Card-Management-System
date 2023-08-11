package com.citi.creditcard.services;


import com.citi.creditcard.entity.Transaction;

import com.citi.creditcard.exceptions.TransactionsNotFoundException;
import com.citi.creditcard.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionRepository repo;

    @Override
    public List<Transaction> getAllByMerchant(String merchant){
        validateStringNotEmpty(merchant, "Please enter merchant to search");
        List<Transaction> transactions = repo.findByMerchant(merchant);
        checkTransactionsNotEmpty(transactions, "No merchant found with name : " + merchant);
        return transactions;
    }

    @Override
    public List<Transaction> getAllByCity(String city){
        validateStringNotEmpty(city, "Please enter a city to search");
        List<Transaction> transactions = repo.findByCity(city);
        checkTransactionsNotEmpty(transactions, "No city found with name : " + city);
        return transactions;
    }

    @Override
    public List<Transaction> getAllByState(String state){
        validateStringNotEmpty(state, "Please enter a city to search");
        List<Transaction> transactions = repo.findByState(state);
        checkTransactionsNotEmpty(transactions, "No state found with name : " + state);
        return transactions;
    }


    @Override
    public List<String> getAllDistinctStates(){
        return repo.findDistinctStateValues();
    }

    @Override
    public List<String> getAllDistinctCity(){
        return repo.findDistinctCityValues();
    }



    // To check empty parameter
    private void validateStringNotEmpty(String value, String message) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    // To check List is empty or not
    private void checkTransactionsNotEmpty(List<Transaction> transactions, String message) {
        if (transactions.isEmpty()) {
            throw new TransactionsNotFoundException(message);
        }
    }
}


