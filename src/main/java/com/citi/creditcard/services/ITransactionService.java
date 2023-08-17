package com.citi.creditcard.services;


import com.citi.creditcard.dto.CitiesInfoDTO;
import com.citi.creditcard.dto.MerchantInfoDTO;
import com.citi.creditcard.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface ITransactionService {


    public List<String> getAllDistinctMerchants();
    public MerchantInfoDTO getTotalAmountByMerchant(String merchant);
    public Page<Transaction> getAllByMerchant(String merchant, Pageable pageable);


    public List<String> getAllDistinctCity();
    public CitiesInfoDTO getTotalAmountByCities(String city);
    public Page<Transaction> getAllByCity(String city, Pageable pageable);



    public Page<Transaction> getAllByState(String state, Pageable pageable);

    public List<String> getAllDistinctStates();

    public List<Transaction> getAllBySpendingAmount(double low,double high);

    public Page<Transaction> getAllByGender(String gender, Pageable pageable);

    public List<String> getAllDistinctSpendingCategories();

    public Page<Transaction> getAllBySpendingCategory(String category, Pageable pageable);





}
