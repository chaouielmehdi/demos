package com.example.demo.log.loggers.factory;

import com.example.demo.log.loggers.Logger;
import org.springframework.stereotype.Component;

@Component
public interface ILoggerFactory {
    Logger getLogger(String loggerType);
}
