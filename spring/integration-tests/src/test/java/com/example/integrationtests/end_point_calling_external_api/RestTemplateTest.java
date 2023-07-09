package com.example.integrationtests.end_point_calling_external_api;

import com.example.integrationtests.dtos.TodoDto;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class RestTemplateTest {
	final TestRestTemplate testRestTemplate = new TestRestTemplate();

	/**
	 * using restTemplate :
	 * ✅ it assumes that the app is already running on port 8080
	 * ✅ it tests the app from end to end (without mocking feign client)
	 */
	@Test
	void integrationTest_using_restTemplate() {
		ResponseEntity<List<TodoDto>> response = testRestTemplate.exchange(
			"http://localhost:8080/end-point-calling-external-api/",
			HttpMethod.GET,
			null,
			new ParameterizedTypeReference<>() {
			}
		);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());

		List<TodoDto> body = response.getBody();
		assertNotNull(body.get(0));
		assertEquals(1, body.get(0).userId);
	}
}
