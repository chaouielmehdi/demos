package com.example.batchtemplate;

import com.example.batchtemplate.entities.UserEntity;
import com.example.batchtemplate.tests_utils.TestSqlQueriesYamlParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.batch.core.ExitStatus.COMPLETED;

@SpringBatchTest
@ContextConfiguration(classes = { BatchTemplateApplication.class, TestSqlQueriesYamlParser.class })
@ExtendWith(SpringExtension.class)
class UsernameShouldBeChangedTest extends AbstractTest {
	@Test
	void emptyDatabase_noUsernameChanged() throws Exception {
		JobExecution jobExecution = jobLauncherTestUtils.launchJob();

		List<UserEntity> userEntities = findAllUsers();
		assertEquals(COMPLETED.getExitCode(), jobExecution.getExitStatus().getExitCode());
		assertEquals(0, userEntities.size());
	}

	@Test
	void oneUserInDatabase_thenOneUsernameShouldBeChanged() throws Exception {
		saveUser(UserEntity.builder().username("username_proposed_by_client").build());

		JobExecution jobExecution = jobLauncherTestUtils.launchJob();

		List<UserEntity> userEntities = findAllUsers();
		assertEquals(COMPLETED.getExitCode(), jobExecution.getExitStatus().getExitCode());
		assertEquals(1, userEntities.size());
		assertEquals("username_changed_by_batch", userEntities.get(0).username);
	}

	private List<UserEntity> findAllUsers() {
		return userRepository.findAll();
	}
}
