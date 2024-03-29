package com.example.designpatternfactorystrategy.enums;

public enum Format {
	MT101("MT101"),
	CSV("CSV");
	public final String value;

	Format(String input) {
		this.value = input;
	}

	public static Format getFormatEnum(String formatAsString) {
		Format format;
		try {
			format = Format.valueOf(formatAsString);
		} catch(IllegalArgumentException e) {
			return null;
		}
		return format;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
