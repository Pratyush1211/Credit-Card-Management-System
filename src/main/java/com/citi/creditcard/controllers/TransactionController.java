package com.citi.creditcard.controllers;

import com.citi.creditcard.entity.Transaction;

import com.citi.creditcard.exceptions.TransactionsNotFoundException;
import com.citi.creditcard.services.TransactionService;
import com.citi.creditcard.utility.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.awt.geom.IllegalPathStateException;
import java.time.LocalDateTime;

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
    @GetMapping("/merchant/{merchant}")
    public ResponseEntity<Object> getTransactionByMerchant(@PathVariable(required = false) String merchant){
        try {
            List<Transaction> transactions = transactionService.getAllByMerchant(merchant);
            return ResponseHandler.generateResponse(LocalDateTime.now(),"Data retrieved successfully", HttpStatus.OK, transactions);
        } catch(IllegalPathStateException e) {
            return ResponseHandler.generateResponse(LocalDateTime.now(), e.getMessage(), HttpStatus.BAD_REQUEST, null );
        }
        catch (TransactionsNotFoundException e) {
            return ResponseHandler.generateResponse(LocalDateTime.now(), e.getMessage(), HttpStatus.OK, new Object[0]);
        }
    }


    /**
     *
     * @param city //
     * @return transactions
     */

    @GetMapping("/city/{city}")
    public ResponseEntity<Object> getTransactionByCity(@PathVariable String city){
        try {
            List<Transaction> transactions = transactionService.getAllByCity(city);
            return ResponseHandler.generateResponse(LocalDateTime.now(),"Data retrieved successfully", HttpStatus.OK, transactions);
        } catch(IllegalPathStateException e) {
            return ResponseHandler.generateResponse(LocalDateTime.now(),e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
        catch (TransactionsNotFoundException e) {
            return ResponseHandler.generateResponse(LocalDateTime.now(),e.getMessage(), HttpStatus.OK, new Object[0]);
        }
    }


    /**
     *
     * @param state //
     * @return transactions
     */
    @GetMapping("/state/{state}")
    public ResponseEntity<Object> getTransactionByState(@PathVariable String state){
        try {
            List<Transaction> transactions = transactionService.getAllByState(state);
            return ResponseHandler.generateResponse(LocalDateTime.now(),"Data retrieved successfully", HttpStatus.OK, transactions);
        } catch(IllegalPathStateException e) {
            return ResponseHandler.generateResponse(LocalDateTime.now(),e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
        catch (TransactionsNotFoundException e) {
            return ResponseHandler.generateResponse(LocalDateTime.now(),e.getMessage(), HttpStatus.OK, new Object[0]);
        }
    }

    @GetMapping("/states")
    public ResponseEntity<Object> getStates(){
            try {
                List<String> transactions = transactionService.getAllDistinctStates();
                return ResponseHandler.generateResponse(LocalDateTime.now(), "Data retrieved successfully", HttpStatus.OK, transactions);
            } catch (RuntimeException e){
                return ResponseHandler.generateResponse(LocalDateTime.now(),"Data retrieval unsuccessfully", HttpStatus.INTERNAL_SERVER_ERROR, null);
            }
    }


    @GetMapping("/cities")
    public ResponseEntity<Object> getCities(){
        try {
            List<String> transactions = transactionService.getAllDistinctStates();
            return ResponseHandler.generateResponse(LocalDateTime.now(), "Data retrieved successfully", HttpStatus.OK, transactions);
        } catch (RuntimeException e){
            return ResponseHandler.generateResponse(LocalDateTime.now(),"Data retrieval unsuccessfully", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }



}
