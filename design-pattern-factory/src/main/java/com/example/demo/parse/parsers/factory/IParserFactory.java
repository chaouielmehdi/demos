package com.example.demo.parse.parsers.factory;

import com.example.demo.parse.enums.ParserType;
import com.example.demo.parse.parsers.IParser;
import org.springframework.stereotype.Component;

@Component
public interface IParserFactory {
    IParser getParser(ParserType parserType);
}
