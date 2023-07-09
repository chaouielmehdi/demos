package com.example.batchtemplate.configs;

import com.example.batchtemplate.enums.SqlQuery;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

@Component
@PropertySource("classpath:sql-queries.yaml")
public class SqlQueriesYamlParser {
	private static final String RESOURCE_FILE_NAME = "sql-queries.yaml";
	private final Yaml yaml = new Yaml(); // TODO try injection instead of new Yaml()

	public String parse(SqlQuery key) {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(RESOURCE_FILE_NAME);
		Map<String, String> parsed = yaml.load(inputStream);
		return parsed.get(key.name());
	}
}
