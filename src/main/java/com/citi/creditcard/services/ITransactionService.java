package com.citi.creditcard.services;


import com.citi.creditcard.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface ITransactionService {

    public Page<Transaction> getAllByMerchant(String merchant, Pageable pageable);

    public Page<Transaction> getAllByCity(String city, Pageable pageable);

    public List<String> getAllDistinctCity();

    public Page<Transaction> getAllByState(String state, Pageable pageable);

    public List<String> getAllDistinctStates();

    public List<Transaction> getAllBySpendingAmount(double low,double high);





}
