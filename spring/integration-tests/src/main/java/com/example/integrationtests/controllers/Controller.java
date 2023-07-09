package com.example.integrationtests.controllers;

import com.example.integrationtests.dtos.TodoDto;
import com.example.integrationtests.feign.TodoFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {
	private final TodoFeignClient todoFeignClient;

	@GetMapping("/end-point-simple/")
	public ResponseEntity<String> getSimple() {
		return ResponseEntity.ok("response-body");
	}

	@GetMapping("/end-point-calling-external-api/")
	public ResponseEntity<List<TodoDto>> getExternalApi() {
		List<TodoDto> todos = todoFeignClient.getTodos();
		return ResponseEntity.ok(todos);
	}

	@GetMapping("/end-point-with-custom-filter/")
	public ResponseEntity<String> getWithFilter(@RequestAttribute String attribute) {
		return ResponseEntity.ok(attribute);
	}
}
