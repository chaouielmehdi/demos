package com.example.batch.template.helpers;

import com.example.batch.template.enums.SqlQuery;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

@Component
public class SqlQueriesYamlParser {
	private final static String SQL_QUERIES = "sql-queries.yaml";
	private final static Yaml yaml = new Yaml();

	public String parse(SqlQuery key) {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(SQL_QUERIES);
		Map<String, String> parsed = yaml.load(inputStream);
		return parsed.get(key.name());
	}
}
