package com.example.integrationtests.end_point_with_custom_filter;

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
	 * ✅ filter does apply (thus, web layer is tested)
	 */
	@Test
	void integrationTest_using_mockMvc() throws Exception {
		mockMvc
			.perform(get("/end-point-with-custom-filter/").param("attribute", "valueFromClient"))
			.andExpect(status().is2xxSuccessful())
			.andExpect(jsonPath("$").value("valueFromFilter"));
	}
}
