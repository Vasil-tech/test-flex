package com.flex.neoflex.services;

import com.flex.neoflex.models.User;
import com.flex.neoflex.repositories.UserService;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProfileRepositoryImpl implements UserService {

	private static final String SQL_GET_PROFILE_BY_NAME =
			"select name, lastname, patronymic, email from usr where name = :name";

	private final ProfileMapper profileMapper;
	private final NamedParameterJdbcTemplate jdbcTemplate;

	public ProfileRepositoryImpl(
			ProfileMapper profileMapper,
			NamedParameterJdbcTemplate jdbcTemplate
	) {
		this.profileMapper = profileMapper;
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void createProfile(Integer bank_id, String lastname, String name, String patronymic, Integer birth, String passport, String city, String phone_number, String email, String address_reg, String address_fact) {

	}

	@Override
	public Optional<User> getUser(String name) {
		var params = new MapSqlParameterSource();
		params.addValue("name", name);
		return jdbcTemplate.query(
						SQL_GET_PROFILE_BY_NAME,
						params,
						profileMapper
				).stream()
				.findFirst();
	}

	@Override
	public Optional<User> getProfile(int personId) {
		return Optional.empty();
	}
}
