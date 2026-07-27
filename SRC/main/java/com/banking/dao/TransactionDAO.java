package com.banking.dao;

import java.util.ArrayList;
import java.util.List;

import com.banking.model.Transaction;

public class TransactionDAO {

    public List<Transaction> getTransactions() {

        List<Transaction> transactions =
                new ArrayList<>();

        Transaction transaction1 =
                new Transaction();

        transaction1.setTransactionId(1001);
        transaction1.setTransactionType("Deposit");
        transaction1.setAmount(10000);

        transactions.add(transaction1);

        Transaction transaction2 =
                new Transaction();

        transaction2.setTransactionId(1002);
        transaction2.setTransactionType("Withdraw");
        transaction2.setAmount(5000);

        transactions.add(transaction2);

        return transactions;

    }

}