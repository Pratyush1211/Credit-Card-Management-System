package com.citi.creditcard.dto;

public class StatesInfoDTO {
    private String state;
    private double total_amount;

    private int transactionCount;

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

