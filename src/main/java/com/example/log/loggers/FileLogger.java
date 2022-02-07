package com.example.log.loggers;

import com.example.log.utils.FileUtils;
import com.example.log.utils.LoggerUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component(value = "file")
public class FileLogger implements ILogger {
    private final String logFilePathname = System.getProperty("user.dir") + "/src/main/resources/log-file.log";

    public void log(String message) {
        FileUtils.create(logFilePathname);

        String messageToLog = LoggerUtils.prepareMessage(message);
        FileUtils.write(logFilePathname, messageToLog);
    }
}
