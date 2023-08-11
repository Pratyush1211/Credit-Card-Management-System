package com.citi.creditcard.controllers;

import com.citi.creditcard.entity.Transaction;

import com.citi.creditcard.exceptions.TransactionsNotFoundException;
import com.citi.creditcard.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")

public class TransactionController {

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
            List<Transaction> transactions = transactionService.getAllByMerchant(merchant);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(transactions);
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        catch (TransactionsNotFoundException e) {
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
            List<Transaction> transactions = transactionService.getAllByCity(city);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(transactions);
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        catch (TransactionsNotFoundException e) {
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
            List<Transaction> transactions = transactionService.getAllByState(state);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(transactions);
        } catch(IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        catch (TransactionsNotFoundException e) {
            throw new TransactionsNotFoundException(e.getMessage());
        }
    }

    @GetMapping("/getAllStates")
    public ResponseEntity<Object> getStates(){
            List<String> transactions = transactionService.getAllDistinctStates();
            return ResponseEntity.ok(transactions);
    }

    @GetMapping("/getAllCities")
    public ResponseEntity<Object> getCities(){
        List<String> transactions = transactionService.getAllDistinctCity();
        return ResponseEntity.ok(transactions);
    }



}
