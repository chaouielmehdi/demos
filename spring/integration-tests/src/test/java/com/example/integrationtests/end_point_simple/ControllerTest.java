package com.example.integrationtests.end_point_simple;

import com.example.integrationtests.controllers.Controller;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class ControllerTest {
	final Controller controller;

	/**
	 * using controller directly :
	 * ✅ this is internal integration test
	 */
	@Test
	void integrationTest_using_controllerDirectly() {
		ResponseEntity<String> response = controller.getSimple();
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("response-body", response.getBody());
	}
}
