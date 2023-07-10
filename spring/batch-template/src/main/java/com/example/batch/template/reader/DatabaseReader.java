package com.example.batch.template.reader;

import com.example.batch.template.entities.UserEntity;
import com.example.batch.template.enums.SqlQuery;
import com.example.batch.template.helpers.SqlQueriesYamlParser;
import com.example.batch.template.reader.mappers.UserRowMapper;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DatabaseReader extends JdbcCursorItemReader<UserEntity> {
	public DatabaseReader(DataSource dataSource, SqlQueriesYamlParser sqlQueriesYamlParser) {
		this.setName("databaseReader");
		this.setSql(sqlQueriesYamlParser.parse(SqlQuery.SELECT_USERS));
		this.setDataSource(dataSource);
		this.setRowMapper(new UserRowMapper());
	}
}
