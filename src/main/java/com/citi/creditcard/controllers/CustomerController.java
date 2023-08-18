package com.citi.creditcard.controllers;


import com.citi.creditcard.entity.Customer;
import com.citi.creditcard.services.CustomerService;
import com.citi.creditcard.utility.SuccessResponseHandler;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
//import java.util.logging.Logger;
import org.slf4j.Logger;

@CrossOrigin("*")

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{customerId}")
    public ResponseEntity<Object> getCustomer(@PathVariable Integer customerId){
        logger.info("Fetching customer with ID: {}", customerId);
        Customer customerDetails = customerService.getCustomer(customerId);
        logger.info("Fetched customer details: {}", customerDetails);
        return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data retrieved successfully", HttpStatus.OK, customerDetails, null);
    }


    @PostMapping()
    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
        logger.info("Adding a new customer: {}", customer);
        Customer addCustomer = customerService.addCustomer(customer);
        logger.info("Added customer: {}", addCustomer);
        return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data added successfully", HttpStatus.CREATED, addCustomer, null);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Object> deleteCustomer(@PathVariable Integer customerId){
        logger.info("Deleting customer with ID: {}", customerId);
        Customer deletecustomer = customerService.deleteCustomer(customerId);
        logger.info("Deleted customer: {}", deletecustomer);
        return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data deleted successfully", HttpStatus.CREATED, deletecustomer, null);
    }

    @GetMapping()
    public ResponseEntity<Object> getAllCustomers(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size){
        logger.info("Fetching all customers with pagination: page={}, size={}", page, size);
        List<Customer> customers;
        Pageable pageable = PageRequest.of(page, size);

        Page<Customer> customerPage = customerService.getAllCustomers(pageable);
        customers = customerPage.getContent();
        logger.info("Fetched {} customers", customers.size());
        return SuccessResponseHandler.generateResponse(LocalDateTime.now(), "Data retrieved successfully", HttpStatus.OK, customers, customerPage);
    }










}
