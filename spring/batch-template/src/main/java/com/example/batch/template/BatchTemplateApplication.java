package com.example.batch.template;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.springframework.boot.SpringApplication.exit;
import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class BatchTemplateApplication {
	public static void main(String... args) {
		int exitCode = exit(run(BatchTemplateApplication.class, args));
		System.exit(exitCode);
	}
}
