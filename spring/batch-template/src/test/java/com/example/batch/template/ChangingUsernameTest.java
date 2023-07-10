package com.example.batch.template;

import com.example.batch.template.entities.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.JobExecution;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.batch.core.ExitStatus.COMPLETED;

class ChangingUsernameTest extends AbstractTest {
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
}
