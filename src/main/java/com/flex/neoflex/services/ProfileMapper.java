package com.flex.neoflex.services;

import com.flex.neoflex.models.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProfileMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new User(
				rs.getString("name"),
				rs.getString("lastname"),
				rs.getString("patronymic"),
				rs.getString("email")
		);
	}
}