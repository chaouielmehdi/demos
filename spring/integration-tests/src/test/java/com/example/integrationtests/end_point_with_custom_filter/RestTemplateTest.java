package com.example.integrationtests.end_point_with_custom_filter;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class RestTemplateTest {
	final TestRestTemplate testRestTemplate = new TestRestTemplate();

	/**
	 * using restTemplate :
	 * ✅ filter does apply (thus, web layer is tested)
	 */
	@Test
	void integrationTest_using_restTemplate() {
		ResponseEntity<String> response = testRestTemplate.getForEntity("http://localhost:8080/end-point-with-custom-filter/", String.class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("valueFromFilter", response.getBody());
	}
}
