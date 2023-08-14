package com.citi.creditcard.controllers;


import com.citi.creditcard.entity.Customer;
import com.citi.creditcard.services.CustomerService;
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
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{customerId}")
    public ResponseEntity<Object> getCustomer(@PathVariable Integer customerId){
        Customer customerDetails = customerService.getCustomer(customerId);
        return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data retrieved successfully", HttpStatus.OK, customerDetails, null);
    }


    @PostMapping()
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
        Customer addCustomer = customerService.addCustomer(customer);
        return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data added successfully", HttpStatus.CREATED, addCustomer, null);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Integer customerId){
        Customer deletecustomer = customerService.deleteCustomer(customerId);
        return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data deleted successfully", HttpStatus.CREATED, deletecustomer, null);
    }

    @GetMapping()
    public ResponseEntity<Object> getAllCustomers(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size){

        List<Customer> customers;
        Pageable pageable = PageRequest.of(page, size);

        Page<Customer> customerPage = customerService.getAllCustomers(pageable);
        customers = customerPage.getContent();

        return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data retrieved successfully", HttpStatus.OK, customers, customerPage);
    }










}
