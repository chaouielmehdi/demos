package com.example.batch.template;

import com.example.batch.template.entities.UserEntity;
import com.example.batch.template.test.helpers.TestUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBatchTest
@ContextConfiguration(classes = {BatchTemplateApplication.class})
@ExtendWith(SpringExtension.class)
class AbstractTest {
	@Autowired
	protected JobLauncherTestUtils jobLauncherTestUtils;
	@Autowired
	private TestUserRepository testUserRepository;

	@BeforeEach
	void setup() {
		testUserRepository.deleteAll();
	}

	protected void saveUser(UserEntity userEntity) {
		testUserRepository.save(userEntity);
	}

	protected List<UserEntity> findAllUsers() {
		return testUserRepository.findAll();
	}
}
