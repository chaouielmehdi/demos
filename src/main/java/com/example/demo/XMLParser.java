package com.example.demo;

class XMLParser implements Parser {
    @Override
    public void parse(String str) {
        System.out.println("XMLParser.parse :: " + str);
    }
}
