package com.example.designpatternfactorystrategy;

import com.example.designpatternfactorystrategy.controllers.ROController;
import com.example.designpatternfactorystrategy.dtos.RODto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class ROReadTest {
	@Autowired
	ROController roController;

	@Test
	public void test_read_isNull() {
		RODto roDto = roController.read("invalid-format");
		boolean expression = roDto == null;
		String message = "RODto object should be null";
		Assert.state(expression, message);
	}

	@Test
	public void test_read_isNotNull() {
		RODto roDto = roController.read("MT101");
		boolean expression = roDto != null;
		String message = "RODto object should be not null";
		Assert.state(expression, message);
	}

	@Test
	public void test_read_amount_MT101() {
		RODto roDto = roController.read("MT101");
		boolean expression = roDto.getTotalAmount() == 200;
		String message = "Amount is not valid";
		Assert.state(expression, message);
	}

	@Test
	public void test_read_amount_CSV() {
		RODto roDto = roController.read("CSV");
		boolean expression = roDto.getTotalAmount() == 100;
		String message = "Amount is not valid";
		Assert.state(expression, message);
	}
}
