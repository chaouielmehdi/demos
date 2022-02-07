package com.example.log.loggers;

import com.example.log.utils.LoggerUtils;
import org.springframework.stereotype.Component;

@Component(value = "console")
public class ConsoleLogger implements ILogger {
    public void log(String message) {
        String messageToLog = LoggerUtils.prepareMessage(message);
        System.out.println(messageToLog);
    }
}
