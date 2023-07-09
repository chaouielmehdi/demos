package com.example.batchtemplate.reader.mappers;

import com.example.batchtemplate.entities.UserEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserEntity> {
	@Override
	public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserEntity userEntity = new UserEntity();
		userEntity.id = rs.getString("OID");
		userEntity.timestamp = rs.getDate("TIMESTAMP");
		userEntity.username = rs.getString("USERNAME");
		return userEntity;
	}
}
