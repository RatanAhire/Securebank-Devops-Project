package com.banking.util;

public class ValidationUtil {

    private ValidationUtil() {

    }

    public static boolean isEmpty(String value) {

        return value == null || value.trim().isEmpty();

    }

    public static boolean isValidAmount(double amount) {

        return amount > 0;

    }

    public static boolean isValidEmail(String email) {

        return email != null
                && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");

    }

}