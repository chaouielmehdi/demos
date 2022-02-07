package com.example.parse.services;

import com.example.parse.enums.ParserType;
import com.example.parse.parsers.IParser;
import com.example.parse.parsers.factory.IParserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParserService {
    @Autowired
    IParserFactory parserFactory;

    public void doParse(String parseString, ParserType parseType) {
        IParser parser = parserFactory.getParser(parseType);

        System.out.println("Calling ParserService.doParse by parser = " + parser);
        parser.parse(parseString);
    }
}
