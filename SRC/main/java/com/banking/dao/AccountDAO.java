package com.banking.dao;

import com.banking.model.Account;

public class AccountDAO {

    public Account getAccount(String username) {

        // TODO:
        // Fetch account from MySQL

        Account account = new Account();

        account.setAccountNumber("SB20260001");
        account.setAccountType("Savings");
        account.setBalance(125000.00);
        account.setBranchName("Mumbai Main Branch");

        return account;

    }

    public boolean deposit(double amount) {

        // TODO:
        // Update Balance

        return true;

    }

    public boolean withdraw(double amount) {

        // TODO:
        // Update Balance

        return true;

    }

    public boolean transfer(String receiverAccount,
                            double amount) {

        // TODO:
        // Transfer Balance

        return true;

    }

}