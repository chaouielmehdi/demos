package com.example.demo.enums;

public enum FormatEnum {
    MT101("MT101"),
    CSV("CSV");

    public final String value;

    FormatEnum(String input) {
        this.value = input;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static FormatEnum getFormatEnum(String formatAsString) {
        FormatEnum format;
        try {
            format = FormatEnum.valueOf(formatAsString);
        } catch (IllegalArgumentException e) {
            return null;
        }

        return format;
    }
}
