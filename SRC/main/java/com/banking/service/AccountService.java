package com.securebank.service;

import com.securebank.model.Account;

public class AccountService {

    public Account getAccountDetails(String username) {

        Account account = new Account();

        account.setAccountNumber("SB20260001");
        account.setAccountType("Savings");
        account.setBalance(125000.00);
        account.setBranchName("Mumbai Main Branch");

        return account;

    }

    public boolean deposit(double amount) {

        return amount > 0;

    }

    public boolean withdraw(double amount) {

        return amount > 0;

    }

    public boolean transfer(String receiverAccount,
                            double amount) {

        return receiverAccount != null
                && !receiverAccount.isEmpty()
                && amount > 0;

    }

}