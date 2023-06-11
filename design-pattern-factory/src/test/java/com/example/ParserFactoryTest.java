package com.example;


import com.example.parse.enums.ParserType;
import com.example.parse.services.ParserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ParserFactoryTest {
    @Autowired
    private ParserService parserService;

    @Test
    public void testParserFactory() {
        String parserTypeAsString = "xmlParser";
        ParserType parserType = ParserType.getParserType(parserTypeAsString);

        System.out.println("------------------------------------------------");
        parserService.doParse("File to be parsed", parserType);
        System.out.println("------------------------------------------------");
    }
}
