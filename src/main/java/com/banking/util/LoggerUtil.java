package com.banking.util;

public class LoggerUtil {

    private LoggerUtil() {

    }

    public static void info(String message) {

        System.out.println("[INFO] " + message);

    }

    public static void error(String message) {

        System.out.println("[ERROR] " + message);

    }

}