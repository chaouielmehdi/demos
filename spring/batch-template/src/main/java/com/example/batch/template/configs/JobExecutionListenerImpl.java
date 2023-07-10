package com.example.batch.template.configs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JobExecutionListenerImpl implements JobExecutionListener {
	@Override
	public void afterJob(JobExecution jobExecution) {
		log.info("JOB FINISHED!");
		log.info("JOB STATUS      : {}", jobExecution.getStatus());
		log.info("JOB START  TIME : {}", jobExecution.getStartTime());
		log.info("JOB END    TIME : {}", jobExecution.getEndTime());
	}
}
