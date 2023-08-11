package com.citi.creditcard.services;


import com.citi.creditcard.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITransactionService {

    public List<Transaction> getAllByMerchant(String merchant);

    public List<Transaction> getAllByCity(String city);

    public List<String> getAllDistinctCity();

    public List<Transaction> getAllByState(String state);

    public List<String> getAllDistinctStates();
}
