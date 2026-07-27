package com.banking.util;

import java.util.Random;

public class AccountNumberGenerator {

    private static final String PREFIX = "SB";

    private static final int ACCOUNT_LENGTH = 10;

    private static final Random RANDOM = new Random();

    private AccountNumberGenerator() {

    }

    public static String generateAccountNumber() {

        StringBuilder accountNumber = new StringBuilder(PREFIX);

        for (int i = 0; i < ACCOUNT_LENGTH; i++) {

            accountNumber.append(RANDOM.nextInt(10));

        }

        return accountNumber.toString();

    }

}