package com.citi.creditcard.entity;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("transactions")

public class Transaction {

    @Field("dob")
    private String DOB;

    @Field("first")
    private String firstName;

    @Field("gender")
    private String gender;

    @Field("last")
    private String lastName;

    @Field("merchant")
    private String merchant;

    @Field("Job")
    private String Job;

    @Field("state")
    private String state;

    @Field("amt")
    private double amount;

    @Field("trans_date_trans_time")
    private String transactionDataandTime;

    @Field("category")
    private String category;

    @Field("trans_num")
    private String transactionNumber;

    @Field("city")
    private String city;

    @Field("city_population")
    private int cityPopulation;

    @Field("customer_id")
    private int customerId;


    public Transaction() {

    }

    public Transaction(String DOB, String firstName, String gender, String lastName, String merchant, String job, String state, double amount, String transactionDataandTime, String category, String transactionNumber, String city, int cityPopulation, int customerId) {
        this.DOB = DOB;
        this.firstName = firstName;
        this.gender = gender;
        this.lastName = lastName;
        this.merchant = merchant;
        this.Job = job;
        this.state = state;
        this.amount = amount;
        this.transactionDataandTime = transactionDataandTime;
        this.category = category;
        this.transactionNumber = transactionNumber;
        this.city = city;
        this.cityPopulation = cityPopulation;
        this.customerId = customerId;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        this.Job = job;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionDataandTime() {
        return transactionDataandTime;
    }

    public void setTransactionDataandTime(String transactionDataandTime) {
        this.transactionDataandTime = transactionDataandTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(int cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString(){
        return String.format("Transaction : [first= %s, last= %s, dob= %s, gender= %s, merchant= %s, Job= %s, state= %s, amt= %s, trans_date_trans_time= %s, category= %s, trans_num= %s, city= %s, city_population= %s, customer_id= %s ]",
                firstName,
                lastName,
                DOB,
                gender,
                merchant,
                Job,
                state,
                amount,
                transactionDataandTime,
                category,
                transactionNumber,
                city,
                cityPopulation,
                customerId
                );

     }

}
