package com.citi.creditcard.services;


import com.citi.creditcard.entity.Transaction;
import com.citi.creditcard.exceptions.MerchantNotFoundException;
import com.citi.creditcard.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionRepository repo;

    @Override
    public List<Transaction> findByMerchant(String merchant){
        return repo.findAll(merchant);
    }


}
