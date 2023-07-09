package com.example.integrationtests.end_point_calling_external_api;

import com.example.integrationtests.dtos.TodoDto;
import com.example.integrationtests.feign.TodoFeignClient;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class MockMvcTest {
	final MockMvc mockMvc;
	@MockBean
	TodoFeignClient todoFeignClient;

	/**
	 * using mockMcv :
	 * ❌ must mock feign client call
	 */
	@Test
	void integrationTest_using_mockMvc() throws Exception {
		when(todoFeignClient.getTodos()).thenReturn(List.of(TodoDto.builder().userId(1).build()));

		mockMvc
			.perform(get("/end-point-calling-external-api/"))
			.andExpect(status().is2xxSuccessful())
			.andExpect(jsonPath("$[0].userId").value(1));
	}
}
