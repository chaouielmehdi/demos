package com.example.designpatternfactory.parse.enums;

public enum ParserType {
    JSON("jsonParser"),
    XML("xmlParser");

    public final String value;

    ParserType(String input) {
        this.value = input;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static ParserType getParserType(String typeAsString) {
        ParserType[] types = ParserType.values();
        for (ParserType type : types) {
            if(type.value.equals(typeAsString)) {
                return type;
            }
        }

        return null;
    }
}
