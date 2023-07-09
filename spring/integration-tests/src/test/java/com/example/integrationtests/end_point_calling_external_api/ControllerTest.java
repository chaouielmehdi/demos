package com.example.integrationtests.end_point_calling_external_api;

import com.example.integrationtests.controllers.Controller;
import com.example.integrationtests.dtos.TodoDto;
import com.example.integrationtests.feign.TodoFeignClient;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class ControllerTest {
	final Controller controller;
	@MockBean
	TodoFeignClient todoFeignClient;

	/**
	 * using controller directly :
	 * ❌ must mock feign client call
	 */
	@Test
	void integrationTest_using_controllerDirectly() {
		when(todoFeignClient.getTodos()).thenReturn(List.of(TodoDto.builder().userId(1).build()));

		ResponseEntity<List<TodoDto>> response = controller.getExternalApi();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());

		List<TodoDto> body = response.getBody();
		assertNotNull(body.get(0));
		assertEquals(1, body.get(0).userId);
	}
}
