package com.example.log.loggers.factory;

import com.example.log.loggers.Logger;
import org.springframework.stereotype.Component;

@Component
public interface ILoggerFactory {
    Logger getLogger(String loggerType);
}
