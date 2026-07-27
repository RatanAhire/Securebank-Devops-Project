package com.banking.model;

public class Account {

    private String accountNumber;

    private int customerId;

    private String accountType;

    private double balance;

    private String ifscCode;

    private String branchName;

    private String accountStatus;

    // Default Constructor
    public Account() {
    }

    // Getters

    public String getAccountNumber() {
    return accountNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    // Setters

   public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

}