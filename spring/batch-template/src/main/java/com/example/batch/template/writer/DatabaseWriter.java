package com.example.batch.template.writer;

import com.example.batch.template.entities.UserEntity;
import com.example.batch.template.enums.SqlQuery;
import com.example.batch.template.helpers.SqlQueriesYamlParser;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DatabaseWriter implements ItemWriter<UserEntity> {
	private final SqlQueriesYamlParser sqlQueriesYamlParser;
	private final JdbcTemplate jdbcTemplate;

	@Override
	public void write(Chunk<? extends UserEntity> users) {
		String sql = sqlQueriesYamlParser.parse(SqlQuery.UPDATE_USERS);
		for(UserEntity user : users) {
			jdbcTemplate.update(sql, user.id);
		}
	}
}
