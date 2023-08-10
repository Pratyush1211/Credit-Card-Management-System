package com.citi.creditcard.services;


import com.citi.creditcard.entity.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITransactionService {

    public List<Transaction> findByGender(String gender);

    public List<Transaction> findByMerchant(String merchant);

    public List<Transaction> findByCity(String city);

    public List<Transaction> findByState(String state);



}
