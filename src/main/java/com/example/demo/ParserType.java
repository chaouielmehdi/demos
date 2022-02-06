package com.example.demo;

enum ParserType {
    JSON("jsonParser"),
    XML("xmlParser");

    private final String value;

    ParserType(String input) {
        this.value = input;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
