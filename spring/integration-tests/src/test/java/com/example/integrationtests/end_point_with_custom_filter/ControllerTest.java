package com.example.integrationtests.end_point_with_custom_filter;

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
	 * ❌ filter does not apply (thus, web layer is not tested)
	 */
	@Test
	void integrationTest_using_controllerDirectly() {
		ResponseEntity<String> response = controller.getWithFilter("valueFromClient");

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("valueFromClient", response.getBody());
	}
}
