package com.citi.creditcard.controllers;

import com.citi.creditcard.dto.CitiesInfoDTO;
import com.citi.creditcard.dto.MerchantInfoDTO;
import com.citi.creditcard.entity.Transaction;

import com.citi.creditcard.services.TransactionService;
import com.citi.creditcard.utility.SuccessResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/transactions/")

public class TransactionController {
    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);


    @Autowired
    private TransactionService transactionService;

    @GetMapping("merchants")
    public ResponseEntity<Object> getMerchantInfo(@RequestParam(value = "merchant", required = false) String merchant){
        logger.info("Fetching merchant info");

        if ( merchant == null) {
            logger.info("Fetching all distinct merchants");
            List<String> transactions = transactionService.getAllDistinctMerchants();
            return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data Retrieved Successfully", HttpStatus.OK, transactions, null );
        }
        else {
            logger.info("Fetching total amount by merchant: {}", merchant);
            MerchantInfoDTO merchantInfoDTO = transactionService.getTotalAmountByMerchant(merchant);
            return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data Retrieved Successfully", HttpStatus.OK, merchantInfoDTO, null);
        }
    }


    /**
     * @param merchant //
     * @return transactions
     */
    @GetMapping("by-merchant/{merchant}")
    public ResponseEntity<Object> getTransactionsByMerchantWithPagination(
            @PathVariable String merchant,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        logger.info("Fetching transactions by merchant with pagination: merchant={}, page={}, size={}", merchant, page, size);

        List<Transaction> transactions;
        Pageable pageable = PageRequest.of(page, size);

        Page<Transaction> pageTransaction = transactionService.getAllByMerchant(merchant, pageable);
        transactions = pageTransaction.getContent();
        logger.info("Fetched {} transactions for merchant {}", transactions.size(), merchant);


        return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data retrieved successfully", HttpStatus.OK, transactions, pageTransaction);

    }

    /**
     * @param low, high //
     * @return transactions
     */
    @GetMapping("/spending")
    public ResponseEntity<Object> getTransactionBySpendingAmt(@RequestParam double low,@RequestParam double high){
        logger.info("Fetching transactions by spending amount: low={}, high={}", low, high);
        List<Transaction> transactions=transactionService.getAllBySpendingAmount(low,high);
        logger.info("Fetched {} transactions for spending amount range: low={}, high={}", transactions.size(), low, high);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(transactions);
    }


    @GetMapping("cities")
    public ResponseEntity<Object> getCityInfo(@RequestParam(value = "city", required = false) String city){
        logger.info("Fetching city information: city={}", city);
        if( city == null ) {
            List<String> transactions = transactionService.getAllDistinctCity();
            logger.info("Fetched city information for all cities");
            return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data Retrieved Successfully", HttpStatus.OK, transactions, null);
        } else {
            CitiesInfoDTO cityInfoDTO = transactionService.getTotalAmountByCities(city);
            logger.info("Fetched city information for city: {}", city);
            return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data Retrieved Successfully", HttpStatus.OK, cityInfoDTO, null);
        }
    }


    @GetMapping("by-cities/{city}")
    public ResponseEntity<Object> getTransactionsByCityWithPagination(
            @PathVariable String city,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        logger.info("Fetching transactions by city with pagination: city={}, page={}, size={}", city, page, size);


        List<Transaction> transactions;
        Pageable pageable = PageRequest.of(page, size);

        Page<Transaction> pageTransaction = transactionService.getAllByCity(city, pageable);
        transactions = pageTransaction.getContent();
        logger.info("Fetched {} transactions for city {} with pagination", transactions.size(), city);

        return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data retrieved successfully", HttpStatus.OK, transactions, pageTransaction);

    }

    @GetMapping("by-states/{state}")
    public ResponseEntity<Object> getTransactionsByStatesWithPagination(
            @PathVariable String state,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        logger.info("Fetching transactions by state with pagination: state={}, page={}, size={}", state, page, size);

        List<Transaction> transactions;
        Pageable pageable = PageRequest.of(page, size);

        Page<Transaction> pageTransaction = transactionService.getAllByState(state, pageable);
        transactions = pageTransaction.getContent();
        logger.info("Fetched {} transactions for state {} with pagination", transactions.size(), state);

        return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data retrieved successfully", HttpStatus.OK, transactions, pageTransaction);

    }

    @GetMapping("by-gender/{gender}")
    public ResponseEntity<Object> getTransactionsByGenderWithPagination(
            @PathVariable String gender,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        logger.info("Fetching transactions by gender with pagination: gender={}, page={}, size={}", gender, page, size);


        List<Transaction> transactions;
        Pageable pageable = PageRequest.of(page, size);

        Page<Transaction> pageTransaction = transactionService.getAllByGender(gender, pageable);
        transactions = pageTransaction.getContent();

        return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data retrieved successfully", HttpStatus.OK, transactions, pageTransaction);

    }


    @GetMapping("by-category/{category}")
    public ResponseEntity<Object> getTransactionsBySpendingCategoryWithPagination(
            @PathVariable String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        logger.info("Fetching transactions by spending category with pagination: category={}, page={}, size={}", category, page, size);

        List<Transaction> transactions;
        Pageable pageable = PageRequest.of(page, size);

        Page<Transaction> pageTransaction = transactionService.getAllBySpendingCategory(category, pageable);
        transactions = pageTransaction.getContent();
        logger.info("Fetched {} transactions for spending category {} with pagination", transactions.size(), category);

        return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data retrieved successfully", HttpStatus.OK, transactions, pageTransaction);

    }


    @GetMapping("/states")
    public ResponseEntity<Object> getStates(){
        logger.info("Fetching distinct states");
        List<String> transactions = transactionService.getAllDistinctStates();
        logger.info("Fetched distinct states: {}", transactions);
        return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data Retrieved Successfully", HttpStatus.OK, transactions, null );
    }


    @GetMapping("/categories")
    public ResponseEntity<Object> getSpendingCategories(){
        logger.info("Fetching distinct spending categories");
        List<String> transactions = transactionService.getAllDistinctSpendingCategories();
        logger.info("Fetched distinct spending categories: {}", transactions);
        return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data Retrieved Successfully", HttpStatus.OK, transactions, null );
    }
}










