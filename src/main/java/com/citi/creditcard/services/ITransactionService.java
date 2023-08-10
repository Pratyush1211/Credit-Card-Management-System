package com.citi.creditcard.services;


import com.citi.creditcard.entity.Transaction;
import com.citi.creditcard.exceptions.MerchantNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITransactionService {



    public List<Transaction> findByMerchant(String merchant) throws MerchantNotFoundException;





}
