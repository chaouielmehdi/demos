package com.example.designpatternfactory.log.services;

import com.example.designpatternfactory.log.loggers.Logger;
import com.example.designpatternfactory.log.loggers.factory.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoggerService {
	@Autowired
	ILoggerFactory iLoggerFactory;

	public void log(String loggerType, String message) {
		Logger iLogger = iLoggerFactory.getLogger(loggerType);
		iLogger.log(message);
	}
}
