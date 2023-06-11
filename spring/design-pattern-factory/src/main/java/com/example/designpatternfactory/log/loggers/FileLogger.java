package com.example.designpatternfactory.log.loggers;

import com.example.designpatternfactory.log.utils.FileUtils;
import org.springframework.stereotype.Component;

@Component(value = "file")
public class FileLogger extends Logger {
    private final String logFilePathname = System.getProperty("user.dir") + "/src/main/resources/log-file.log";

    public void log(String message) {
        FileUtils.create(logFilePathname);

        String messageToLog = prepareMessage(message);
        FileUtils.write(logFilePathname, messageToLog);
    }
}
