package com.citi.creditcard.services;

import com.citi.creditcard.entity.Customer;
import com.citi.creditcard.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {

    public Page<Customer> getAllCustomers(Pageable pageable);

    public Customer getCustomer(Integer customerId);

    public Customer addCustomer(Customer data);

    public Customer deleteCustomer(Integer customerId);
}
