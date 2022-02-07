package com.example.demo.parsers.factory;

import com.example.demo.enums.ParserType;
import com.example.demo.parsers.IParser;
import org.springframework.stereotype.Component;

@Component
public interface IParserFactory {
    IParser getParser(ParserType parserType);
}
