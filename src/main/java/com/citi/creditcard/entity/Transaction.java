package com.citi.creditcard.entity;


import org.springframework.data.mongodb.core.mapping.Document;

@Document("transactions")

public class Transaction {

    private String DOB;
    private String firstName;

    private String gender;
    private String lastName;

    private String merchant;

    private String Job;

    private String state;

    private double amount;

    private String transactionDataandTime;

    private String category;

    private String transactionNumber;

    private String city;

    private int cityPopulation;

    private int customerId;


}
