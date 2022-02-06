package com.example.demo;

class JsonParser implements Parser {
    @Override
    public void parse(String str) {
        System.out.println("Calling JsonParser.parse and str = " + str);
    }
}
