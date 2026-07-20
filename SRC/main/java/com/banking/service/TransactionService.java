package com.securebank.service;

import java.util.ArrayList;
import java.util.List;

import com.securebank.model.Transaction;

public class TransactionService {

    public List<Transaction> getTransactionHistory() {

        List<Transaction> transactions =
                new ArrayList<>();

        Transaction t1 = new Transaction();

        t1.setTransactionId(1001);
        t1.setTransactionType("Deposit");
        t1.setAmount(10000);

        transactions.add(t1);

        Transaction t2 = new Transaction();

        t2.setTransactionId(1002);
        t2.setTransactionType("Withdraw");
        t2.setAmount(2500);

        transactions.add(t2);

        return transactions;

    }

}