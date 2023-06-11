package com.example.designpatternfactorystrategy.enums;

public enum ValidateBehavior {
	CSVValidateBehavior("CSVValidateBehavior"),
	MT101ValidateBehavior("MT101ValidateBehavior");
	private static final String BEHAVIOR_NAME = "ValidateBehavior";
	public final String value;

	ValidateBehavior(String value) {
		this.value = value;
	}

	public static ValidateBehavior getBehaviorEnum(Format format) {
		if(format == null) {
			return null;
		}
		ValidateBehavior behavior;
		try {
			behavior = ValidateBehavior.valueOf(format.value + BEHAVIOR_NAME);
		} catch(IllegalArgumentException e) {
			return null;
		}
		return behavior;
	}

	@Override
	public String toString() {
		return this.value;
	}
}
