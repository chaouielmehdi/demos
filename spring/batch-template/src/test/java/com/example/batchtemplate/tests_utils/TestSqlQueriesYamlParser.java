package com.example.batchtemplate.tests_utils;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

@Component
@PropertySource("classpath:sql-queries.yaml")
// TODO use SqlQueriesYamlParser instead of creating new one
public class TestSqlQueriesYamlParser {
	private static final String RESOURCE_FILE_NAME = "sql-queries.yaml";
	private final Yaml yaml = new Yaml();

	public String parse(TestSqlQuery key) {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(RESOURCE_FILE_NAME);
		Map<String, String> parsed = yaml.load(inputStream);
		return parsed.get(key.name());
	}
}
