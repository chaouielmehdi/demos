package com.example.designpatternfactorystrategy.formats.behaviors.implementations.MT101;

import com.example.designpatternfactorystrategy.dtos.RODto;
import com.example.designpatternfactorystrategy.formats.behaviors.IReadBehavior;
import org.springframework.stereotype.Component;

@Component(value = "MT101ReadBehavior")
public class MT101ReadBehavior implements IReadBehavior {
	@Override
	public RODto read() {
		// 1- read from file
		// 2- construct RODto object
		// 3- return it
		return new RODto(200);
	}
}
