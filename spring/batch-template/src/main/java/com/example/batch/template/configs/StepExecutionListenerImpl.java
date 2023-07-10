package com.example.batch.template.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StepExecutionListenerImpl implements StepExecutionListener {
	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		log.info("STEP FINISHED! {}", stepExecution.getSummary());
		return stepExecution.getExitStatus();
	}
}
