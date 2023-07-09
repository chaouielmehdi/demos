package com.example.integrationtests.feign;

import com.example.integrationtests.dtos.TodoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "TodoFeignClient", url = "https://jsonplaceholder.typicode.com")
public interface TodoFeignClient {
	@GetMapping("/todos")
	List<TodoDto> getTodos();
}
