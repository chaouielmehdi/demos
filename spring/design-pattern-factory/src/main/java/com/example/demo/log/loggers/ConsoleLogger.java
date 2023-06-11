package com.example.demo.log.loggers;

import org.springframework.stereotype.Component;

@Component(value = "console")
public class ConsoleLogger extends Logger {
    public void log(String message) {
        String messageToLog = prepareMessage(message);
        System.out.println(messageToLog);
    }
}
