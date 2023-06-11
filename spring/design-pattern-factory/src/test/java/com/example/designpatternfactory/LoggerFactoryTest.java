package com.example.designpatternfactory;

import com.example.designpatternfactory.log.services.LoggerService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoggerFactoryTest {
    @Autowired
    LoggerService loggerService;

    @Test
    public void testLoggerFactory() {
        System.out.println("------------------------------------------------");
        loggerService.log("file", "message to log");
        System.out.println("------------------------------------------------");
    }
}
