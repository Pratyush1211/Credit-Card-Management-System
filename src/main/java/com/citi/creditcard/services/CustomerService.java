package com.citi.creditcard.services;

import com.citi.creditcard.entity.Customer;

import com.citi.creditcard.exceptions.CustomerAlreadyExistsException;

import com.citi.creditcard.exceptions.CustomerNotFoundException;
import com.citi.creditcard.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private CustomerRepository repo;

    @Override
    public Customer addCustomer(Customer data){
        StringBuilder missingFields = new StringBuilder();

        if (data == null) {
            throw new IllegalArgumentException("Customer data is missing");
        }

        if (data.getFirstName() == null || data.getFirstName().isEmpty()) {
            missingFields.append("First Name, ");
        }
        if (data.getLastName() == null || data.getLastName().isEmpty()) {
            missingFields.append("Last Name, ");
        }
        if (data.getGender() == null || data.getGender().isEmpty()) {
            missingFields.append("Gender, ");
        }
        if (data.getJOB() == null || data.getJOB().isEmpty()) {
            missingFields.append("Job, ");
        }
        if (data.getDOB() == null ) {
            missingFields.append("Date of Birth, ");
        }

        if (!missingFields.isEmpty()) {
            String errorMessage = "The following fields are missing: " + missingFields.substring(0, missingFields.length() - 2);
            throw new IllegalArgumentException(errorMessage);
        }
        if( repo.existsByCustomerId(data.getCustomerId()))
            throw new CustomerAlreadyExistsException("Customer already present with ID: " + data.getCustomerId());
        return  repo.save(data);
    }

    @Override
    public Page<Customer> getAllCustomers(Pageable pageable){
         return repo.findAll(pageable);
    }


    @Override
    public Customer deleteCustomer(Integer customerId){
        if (customerId == null) {
            throw new IllegalArgumentException("Please enter customer ID");
        }
        if (!repo.existsByCustomerId(customerId))
            throw new CustomerNotFoundException("No customer exists with ID: " + customerId);
        return repo.deleteCustomerByCustomerId(customerId);
    }

    @Override
    public Customer getCustomer(Integer customerId){
        if (customerId == null) {
            throw new IllegalArgumentException("Please enter customer ID");
        }
        if (!repo.existsByCustomerId(customerId))
            throw new CustomerNotFoundException("No customer exists with ID: " + customerId);
        return repo.deleteCustomerByCustomerId(customerId);
    }

}
