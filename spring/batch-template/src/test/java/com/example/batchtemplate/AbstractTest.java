package com.example.batchtemplate;

import com.example.batchtemplate.entities.UserEntity;
import com.example.batchtemplate.repository.UserRepository;
import com.example.batchtemplate.tests_utils.TestSqlQueriesYamlParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBatchTest
@ContextConfiguration(classes = { BatchTemplateApplication.class, TestSqlQueriesYamlParser.class })
@ExtendWith(SpringExtension.class)
class AbstractTest {
	@Autowired
	protected UserRepository userRepository;
	@Autowired
	protected JobLauncherTestUtils jobLauncherTestUtils;

	@BeforeEach
	void setup() {
		userRepository.deleteAll();
	}

	protected void saveUser(UserEntity userEntity) {
		userRepository.save(userEntity);
	}
}
