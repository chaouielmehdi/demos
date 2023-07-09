package com.example.batchtemplate.configs;

import com.example.batchtemplate.entities.UserEntity;
import com.example.batchtemplate.processor.Processor;
import com.example.batchtemplate.reader.Reader;
import com.example.batchtemplate.writer.DatabaseWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class BatchConfiguration {
	private final JobRepository jobRepository;
	private final PlatformTransactionManager platformTransactionManager;
	private final JobExecutionListenerImpl jobExecutionListener;
	private final StepExecutionListenerImpl stepExecutionListener;
	private final Reader reader;
	private final Processor processor;
	private final DatabaseWriter databaseWriter;

	@Bean
	public Job job() {
		return new JobBuilder("job", jobRepository)
			.incrementer(new RunIdIncrementer())
			.listener(jobExecutionListener)
			.start(step())
			.build();
	}

	@Bean
	public Step step() {
		return new StepBuilder("step", jobRepository)
			.<UserEntity, UserEntity>chunk(10, platformTransactionManager)
			.listener(stepExecutionListener)
			.reader(reader)
			.processor(processor)
			.writer(databaseWriter)
			.build();
	}
}
