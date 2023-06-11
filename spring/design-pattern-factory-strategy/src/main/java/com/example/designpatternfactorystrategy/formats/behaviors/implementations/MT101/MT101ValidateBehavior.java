package com.example.designpatternfactorystrategy.formats.behaviors.implementations.MT101;

import com.example.designpatternfactorystrategy.enums.ErrorMessage;
import com.example.designpatternfactorystrategy.formats.behaviors.IValidateBehavior;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "MT101ValidateBehavior")
public class MT101ValidateBehavior implements IValidateBehavior {
	@Override
	public List<ErrorMessage> validate() {
		// 1- validate RODto
		// 2- return list of errors
		return new ArrayList<>();
	}
}