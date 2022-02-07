package com.example.log.loggers.factory;

import com.example.log.loggers.ILogger;
import org.springframework.stereotype.Component;

@Component
public interface ILoggerFactory {
    ILogger getLogger(String loggerType);
}
