package com.citi.creditcard.repository;

import com.citi.creditcard.entity.Customer;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface CustomerRepository extends MongoRepository<Customer, Integer> {


    boolean existsByCustomerId(Integer customerId);

    }

