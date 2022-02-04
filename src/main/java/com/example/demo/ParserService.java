package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class ParserService {

    @Autowired
    ParserFactory parserFactory;

    public void doParse(String parseString, ParserType parseType) {
        Parser parser = parserFactory.getParser(parseType);
        System.out.println("ParserService.doParse... " + parser);
        parser.parse(parseString);
    }
}
