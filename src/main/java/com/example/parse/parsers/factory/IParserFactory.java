package com.example.parse.parsers.factory;

import com.example.parse.enums.ParserType;
import com.example.parse.parsers.IParser;
import org.springframework.stereotype.Component;

@Component
public interface IParserFactory {
    IParser getParser(ParserType parserType);
}
