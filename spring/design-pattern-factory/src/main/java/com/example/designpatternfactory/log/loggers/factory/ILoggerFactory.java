package com.example.designpatternfactory.log.loggers.factory;

import com.example.designpatternfactory.log.loggers.Logger;
import org.springframework.stereotype.Component;

@Component
public interface ILoggerFactory {
    Logger getLogger(String loggerType);
}
