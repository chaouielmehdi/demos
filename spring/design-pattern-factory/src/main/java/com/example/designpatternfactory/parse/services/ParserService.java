package com.example.designpatternfactory.parse.services;

import com.example.designpatternfactory.parse.enums.ParserType;
import com.example.designpatternfactory.parse.parsers.IParser;
import com.example.designpatternfactory.parse.parsers.factory.IParserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParserService {
    @Autowired
    IParserFactory parserFactory;

    public void doParse(String parseString, ParserType parserType) {
        IParser parser = parserFactory.getParser(parserType);

        System.out.println("Calling ParserService.doParse by parser = " + parser);
        parser.parse(parseString);
    }
}
