package com.example.designpatternfactory.log.loggers;

import java.util.Date;

public abstract class Logger {
    public abstract void log(String message);

    public String prepareMessage(String message) {
        return new Date() + " :: " + message;
    }
}
