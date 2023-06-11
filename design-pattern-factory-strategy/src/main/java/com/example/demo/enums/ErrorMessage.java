package com.example.demo.enums;

public enum ErrorMessage {
    INVALID_AMOUNT("INVALID_AMOUNT");

    public final String value;

    ErrorMessage(String input) {
        this.value = input;
    }

    @Override
    public String toString() {
        return this.value;
    }

}
