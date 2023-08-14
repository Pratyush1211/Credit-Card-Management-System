package com.citi.creditcard.controllers;


import com.citi.creditcard.entity.Customer;
import com.citi.creditcard.services.CustomerService;
import com.citi.creditcard.utility.SuccessResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin("*")

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping()
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
        Customer addCustomer = customerService.addCustomer(customer);
        return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data added successfully", HttpStatus.CREATED, addCustomer, null);
    }





}
