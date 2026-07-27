package com.banking.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private DateUtil() {

    }

    public static String getCurrentDate() {

        SimpleDateFormat sdf =
                new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        return sdf.format(new Date());

    }

}