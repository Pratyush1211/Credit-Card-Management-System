package com.citi.creditcard.controllers;

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


@CrossOrigin("*")
@RestController
@RequestMapping("/api/transactions/")

public class TransactionController {

    @Autowired
    private TransactionService transactionService;

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

            List<Transaction> transactions;
            Pageable pageable = PageRequest.of(page, size);

            Page<Transaction> pageTransaction = transactionService.getAllByMerchant(merchant, pageable);
            transactions = pageTransaction.getContent();

            return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data retrieved successfully", HttpStatus.OK, transactions, pageTransaction);

    }


    @GetMapping("by-cities/{city}")
    public ResponseEntity<Object> getTransactionsByCityWithPagination(
            @PathVariable String city,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        List<Transaction> transactions;
        Pageable pageable = PageRequest.of(page, size);

        Page<Transaction> pageTransaction = transactionService.getAllByCity(city, pageable);
        transactions = pageTransaction.getContent();

        return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data retrieved successfully", HttpStatus.OK, transactions, pageTransaction);

    }

    @GetMapping("by-states/{state}")
    public ResponseEntity<Object> getTransactionsByStatesWithPagination(
            @PathVariable String state,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {

        List<Transaction> transactions;
        Pageable pageable = PageRequest.of(page, size);

        Page<Transaction> pageTransaction = transactionService.getAllByState(state, pageable);
        transactions = pageTransaction.getContent();

        return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data retrieved successfully", HttpStatus.OK, transactions, pageTransaction);

    }

    @GetMapping("/states")
    public ResponseEntity<Object> getStates(){
        List<String> transactions = transactionService.getAllDistinctStates();
        return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data Retrieved Successfully", HttpStatus.OK, transactions, null );
    }

    @GetMapping("/cities")
    public ResponseEntity<Object> getCities(){
        List<String> transactions = transactionService.getAllDistinctCity();
        return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data Retrieved Successfully", HttpStatus.OK, transactions, null );
    }
}










