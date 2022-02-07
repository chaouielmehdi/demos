package com.example.log.utils;

import java.util.Date;

public class LoggerUtils {
    public static String prepareMessage(String message) {
        return new Date() + " :: " + message;
    }
}
