package com.citi.creditcard.services;

import com.citi.creditcard.dto.CitiesInfoDTO;
import com.citi.creditcard.dto.MerchantInfoDTO;
import com.citi.creditcard.entity.Transaction;

import com.citi.creditcard.exceptions.TransactionsNotFoundException;

import com.citi.creditcard.repository.TransactionDALMongoTemplate;
import com.citi.creditcard.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public class TransactionService implements ITransactionService {
    private static final Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    private TransactionRepository repo;

    @Autowired
    private TransactionDALMongoTemplate dalMongoTemplate;


    // merchant methods
    @Override
    public List<String> getAllDistinctMerchants(){
        logger.debug("Getting all distinct merchants");
        return repo.findDistinctMerchantValues();
    }

    @Override
    public MerchantInfoDTO getTotalAmountByMerchant(String merchant) {
        logger.debug("Getting total amount by merchant: {}", merchant);
        return dalMongoTemplate.findMerchantTransactionDetails(merchant);
    }

    @Override
    public Page<Transaction> getAllByMerchant(String merchant, Pageable pageable){
        logger.debug("Getting transactions by merchant: {}", merchant);
        validateStringNotEmpty(merchant, "Please enter merchant name to search");
        Page<Transaction> transactions = repo.findByMerchant(merchant,pageable);
        checkTransactionsNotEmpty(transactions, "No merchant found with name : " + merchant);
        return transactions;
    }



    // city methods
    @Override
    public CitiesInfoDTO getTotalAmountByCities(String city){
        logger.debug("Getting total amount by city: {}", city);
        return dalMongoTemplate.findCityTransactionDetails(city);
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
        logger.debug("Getting transactions by city: {}", state);
        validateStringNotEmpty(state, "Please enter a state to search");
        Page<Transaction> transactions = repo.findByState(state, pageable);
        checkTransactionsNotEmpty(transactions, "No state found with name : " + state);
        return transactions;
    }


    @Override
    public List<String> getAllDistinctStates(){
        logger.debug("Getting all distinct states");
        return repo.findDistinctStateValues();
    }

    @Override
    public List<String> getAllDistinctCity(){
        logger.debug("Getting all distinct cities");
        return repo.findDistinctCityValues();
    }

    @Override
    public List<Transaction> getAllBySpendingAmount(double low,double high) {
        logger.debug("Getting transactions by spending amount range: [{}, {}]", low, high);
        return repo.findByAmount(low,high);
    }

    @Override
    public List<String> getAllDistinctSpendingCategories(){
        logger.debug("Getting all distinct spending categories");
        return repo.findDistinctSpendingCategories();
    }

    @Override
    public Page<Transaction> getAllByGender(String gender, Pageable pageable){
        validateStringNotEmpty(gender, "Please select male or female");
        Page<Transaction> transactions = repo.findByGender(gender, pageable);
        checkTransactionsNotEmpty(transactions, "No state found with gender : " + gender);
        return transactions;
    }

    @Override
    public Page<Transaction> getAllBySpendingCategory(String category, Pageable pageable){
        logger.debug("Getting transactions by category: {}", category);
        validateStringNotEmpty(category, "Please enter a category to search");
        Page<Transaction> transactions = repo.findByCategory(category, pageable);
        checkTransactionsNotEmpty(transactions, "No state found with name : " + category);
        return transactions;

    }

    // To check empty parameter
    private void validateStringNotEmpty(String value, String message) {
        System.out.println(value);
        if (value == null || value.trim().isEmpty()) {
            logger.error("Empty or null value encountered: {}", message);
            throw new IllegalArgumentException(message);
        }
    }

    // To check List is empty or not
    private void checkTransactionsNotEmpty(Page<Transaction> transactions, String message) {
        if (transactions.isEmpty()) {
            logger.warn("No transactions found: {}", message);
            throw new TransactionsNotFoundException(message);
        }
    }
}


