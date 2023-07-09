package com.example.integrationtests.end_point_simple;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class MockMvcTest {
	final MockMvc mockMvc;

	/**
	 * using mockMcv :
	 * ✅ no need to run the app manually (like testRestTemplate)
	 * ✅ this is internal integration test
	 */
	@Test
	void integrationTest_using_mockMvc() throws Exception {
		mockMvc
			.perform(get("/end-point-simple/"))
			.andExpect(status().is2xxSuccessful())
			.andExpect(jsonPath("$").value("response-body"));
	}
}
