package com.example.demo.enums;

public enum ReadBehavior {
    CSVReadBehavior("CSVReadBehavior"),
    MT101ReadBehavior("MT101ReadBehavior");

    private static final String READ_BEHAVIOR = "ReadBehavior";
    public final String value;

    ReadBehavior(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public static ReadBehavior getBehaviorEnum(Format format) {
        if(format == null) {
            return null;
        }

        ReadBehavior behavior;
        try {
            behavior = ReadBehavior.valueOf(format.value + READ_BEHAVIOR);
        } catch (IllegalArgumentException e) {
            return null;
        }

        return behavior;
    }
}
