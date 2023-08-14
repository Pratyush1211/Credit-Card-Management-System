package com.citi.creditcard.services;


import com.citi.creditcard.entity.Transaction;

import com.citi.creditcard.exceptions.TransactionsNotFoundException;
import com.citi.creditcard.repository.TransactionRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionRepository repo;

    @Override
    public Page<Transaction> getAllByMerchant(String merchant, Pageable pageable){
        validateStringNotEmpty(merchant, "Please enter merchant name to search");
        Page<Transaction> transactions = repo.findByMerchant(merchant,pageable);
        checkTransactionsNotEmpty(transactions, "No merchant found with name : " + merchant);
        return transactions;
    }



    @Override
    public Page<Transaction> getAllByCity(String city, Pageable pageable){
        validateStringNotEmpty(city, "Please enter a city to search");
        Page<Transaction> transactions = repo.findByCity(city, pageable);
        checkTransactionsNotEmpty(transactions, "No city found with name : " + city);
        return transactions;
    }


    @Override
    public Page<Transaction> getAllByState(String state, Pageable pageable){
        validateStringNotEmpty(state, "Please enter a state to search");
        Page<Transaction> transactions = repo.findByState(state, pageable);
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
        System.out.println(value);
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    // To check List is empty or not
    private void checkTransactionsNotEmpty(Page<Transaction> transactions, String message) {
        if (transactions.isEmpty()) {
            throw new TransactionsNotFoundException(message);
        }
    }
}


