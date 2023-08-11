package com.citi.creditcard.controllers;

import com.citi.creditcard.entity.Transaction;
import com.citi.creditcard.exceptions.TransactionsNotFoundException;
import com.citi.creditcard.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

@RestController
@RequestMapping("/api/transactions")

public class TransactionController {
    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    @Autowired
    private TransactionService transactionService;

    /**
     *
     * @param merchant //
     * @return transactions
     */
    @GetMapping("/findByMerchant")
    public ResponseEntity<Object> getTransactionByMerchant(@RequestParam(name = "merchant") String merchant){
        try {
            logger.info("Request received for transactions by merchant: {}", merchant);
            List<Transaction> transactions = transactionService.getAllByMerchant(merchant);
            logger.info("Found {} transactions for merchant: {}", transactions.size(), merchant);

            return ResponseEntity.status(HttpStatus.ACCEPTED).body(transactions);
        } catch(IllegalArgumentException e) {
            logger.error("IllegalArgumentException occurred: {}", e.getMessage(), e);
            throw new IllegalArgumentException(e.getMessage());
        }
        catch (TransactionsNotFoundException e) {
            logger.error("TransactionsNotFoundException occurred: {}", e.getMessage(), e);
            throw new TransactionsNotFoundException(e.getMessage());
        }
    }

    /**
     *
     * @param city //
     * @return transactions
     */

    @GetMapping("/findByCity")
    public ResponseEntity<Object> getTransactionByCity(@RequestParam String city){
        try {
            logger.info("Request received for transactions by city: {}", city);

            List<Transaction> transactions = transactionService.getAllByCity(city);
            logger.info("Found {} transactions for city: {}", transactions.size(), city);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(transactions);
        } catch(IllegalArgumentException e) {
            logger.error("IllegalArgumentException occurred: {}", e.getMessage(), e);

            throw new IllegalArgumentException(e.getMessage());
        }
        catch (TransactionsNotFoundException e) {
            logger.error("TransactionsNotFoundException occurred: {}", e.getMessage(), e);

            throw new TransactionsNotFoundException(e.getMessage());
        }
    }


    /**
     *
     * @param state //
     * @return transactions
     */
    @GetMapping("/findByState")
    public ResponseEntity<Object> getTransactionByState(@RequestParam String state){
        try {
            logger.info("Request received for transactions by state: {}", state);
            List<Transaction> transactions = transactionService.getAllByState(state);
            logger.info("Found {} transactions for state: {}", transactions.size(), state);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(transactions);
        } catch(IllegalArgumentException e) {
            logger.error("IllegalArgumentException occurred: {}", e.getMessage(), e);
            throw new IllegalArgumentException(e.getMessage());
        }
        catch (TransactionsNotFoundException e) {
            logger.error("TransactionsNotFoundException occurred: {}", e.getMessage(), e);
            throw new TransactionsNotFoundException(e.getMessage());
        }
    }

    /*@GetMapping("/getAllStates")
    public ResponseEntity<Object> getStates(){
            List<String> transactions = transactionService.getAllDistinctStates();
            return ResponseEntity.ok(transactions);
    }*/
    @GetMapping("/getAllStates")
    public ResponseEntity<Object> getStates() {
        try {
            logger.info("Request received for all distinct states.");

            List<String> states = transactionService.getAllDistinctStates();

            logger.info("Found {} distinct states.", states.size());

            return ResponseEntity.ok(states);
        } catch (Exception e) {
            logger.error("An error occurred while fetching distinct states: {}", e.getMessage(), e);
            throw e;
        }
    }

    /*@GetMapping("/getAllCities")
    public ResponseEntity<Object> getCities(){
        List<String> transactions = transactionService.getAllDistinctCity();
        return ResponseEntity.ok(transactions);
    }*/
    @GetMapping("/getAllCities")
    public ResponseEntity<Object> getCities() {
        try {
            logger.info("Request received for all distinct cities.");

            List<String> cities = transactionService.getAllDistinctCity();

            logger.info("Found {} distinct cities.", cities.size());

            return ResponseEntity.ok(cities);
        } catch (Exception e) {
            logger.error("An error occurred while fetching distinct cities: {}", e.getMessage(), e);
            throw e;
        }
    }


}
