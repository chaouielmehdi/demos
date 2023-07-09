package com.example.batchtemplate.reader;

import com.example.batchtemplate.entities.UserEntity;
import com.example.batchtemplate.configs.SqlQueriesYamlParser;
import com.example.batchtemplate.enums.SqlQuery;
import com.example.batchtemplate.reader.mappers.UserRowMapper;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class Reader extends JdbcCursorItemReader<UserEntity> {
	public Reader(DataSource dataSource, SqlQueriesYamlParser sqlQueriesYamlParser) {
		this.setName("usersReader");
		this.setSql(sqlQueriesYamlParser.parse(SqlQuery.SELECT_USERS));
		this.setDataSource(dataSource);
		this.setRowMapper(new UserRowMapper());
	}
}
