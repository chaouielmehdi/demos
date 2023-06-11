package com.example.designpatternfactory.parse.parsers.factory;

import com.example.designpatternfactory.parse.enums.ParserType;
import com.example.designpatternfactory.parse.parsers.IParser;
import org.springframework.stereotype.Component;

@Component
public interface IParserFactory {
	IParser getParser(ParserType parserType);
}
