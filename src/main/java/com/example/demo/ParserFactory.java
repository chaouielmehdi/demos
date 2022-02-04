package com.example.demo;

import org.springframework.stereotype.Component;

@Component
interface ParserFactory {
    Parser getParser(ParserType parserType);
}
