package com.example.demo.enums;

public enum Behavior {
    ReadBehavior("ReadBehavior"),
    ValidateBehavior("ValidateBehavior");

    public final String value;

    Behavior(String input) {
        this.value = input;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static String combineFormatAndBehavior(String formatAsString, Behavior behavior) {
        Format format = Format.getFormatEnum(formatAsString);
        if(format == null) {
            return null;
        }

        return format.value + behavior.value;
    }
}
