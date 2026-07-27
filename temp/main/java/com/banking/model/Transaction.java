package com.banking.model;

import java.time.LocalDateTime;

public class Transaction {

    private int transactionId;

    private long accountNumber;

    private String transactionType;

    private double amount;

    private double availableBalance;

    private LocalDateTime transactionDate;

    private String status;

    // Default Constructor
    public Transaction() {

    }

    // Getters

    public int getTransactionId() {
        return transactionId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public String getStatus() {
        return status;
    }

    // Setters

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}