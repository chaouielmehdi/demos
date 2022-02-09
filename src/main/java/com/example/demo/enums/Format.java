package com.example.demo.enums;

public enum Format {
    MT101("MT101"),
    CSV("CSV");

    public final String value;

    Format(String input) {
        this.value = input;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static Format getFormatEnum(String formatAsString) {
        Format format;
        try {
            format = Format.valueOf(formatAsString);
        } catch (IllegalArgumentException e) {
            return null;
        }

        return format;
    }
}
