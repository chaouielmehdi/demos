package com.example.demo;


import com.example.demo.enums.ParserType;
import com.example.demo.services.ParserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FactoryTest {
    @Autowired
    private ParserService parserService;

    @Test
    public void testParserFactory() {
//        String parserTypeAsString = "";
        String parserTypeAsString = "jsonParser";
        ParserType parserType = ParserType.getParserType(parserTypeAsString);

        System.out.println("------------------------------------------------");
        parserService.doParse("File to be parsed", parserType);
        System.out.println("------------------------------------------------");
    }
}
