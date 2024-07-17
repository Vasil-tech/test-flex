package com.flex.neoflex.services;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Primary
@Service
public class ValidationRegServiceImpl implements ValidationRegService{
	private final NamedParameterJdbcTemplate jdbcTemplate;

	private static final String SQL_INSERT_USER_EMAIL =
			"insert into usr (name, email) values (:name, :email)";
	private static final String SQL_INSERT_USER_MOBILE =
			"insert into usr (phone_number) values (:phone_number)";
	private static final String SQL_INSERT_USER_BANK =
			"insert into usr (bank_id, lastname, name, patronymic, birth, passport) values (:bank_id, :lastname, :name, :patronymic, :birth, :passport)";
	private static final String SQL_INSERT_USER_GOSU =
			"insert into usr (bank_id, lastname, name, patronymic, birth, passport, city, phone_number, address_reg) values (:bank_id, :lastname, :name, :patronymic, :birth, :passport, :city, :phone_number, :address_reg)";

	public ValidationRegServiceImpl(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void createProfileEmail(String name, String email) {
		var params = new MapSqlParameterSource();
		params.addValue("name", name);
		params.addValue("email", email);
		jdbcTemplate.update(SQL_INSERT_USER_EMAIL, params);
	}

	@Override
	public void createProfileMobile(String phone_number) {
		var params = new MapSqlParameterSource();
		params.addValue("phone_number", phone_number);
		jdbcTemplate.update(SQL_INSERT_USER_MOBILE, params);
	}

	@Override
	public void createProfileBank(Integer bank_id, String name, String lastname, String patronymic, Integer birth, String passport) {
		var params = new MapSqlParameterSource();
		params.addValue("bank_id", bank_id);
		params.addValue("lastname", lastname);
		params.addValue("name", name);
		params.addValue("patronymic", patronymic);
		params.addValue("birth", birth);
		params.addValue("passport", passport);
		jdbcTemplate.update(SQL_INSERT_USER_BANK, params);
	}

	@Override
	public void createProfileGosu(Integer bank_id, String name, String lastname, String patronymic, Integer birth, String passport, String city, String phone_number, String address_reg) {
		var params = new MapSqlParameterSource();
		params.addValue("bank_id", bank_id);
		params.addValue("lastname", lastname);
		params.addValue("name", name);
		params.addValue("patronymic", patronymic);
		params.addValue("birth", birth);
		params.addValue("passport", passport);
		params.addValue("city", city);
		params.addValue("phone_number", phone_number);
		params.addValue("address_reg", address_reg);
		jdbcTemplate.update(SQL_INSERT_USER_GOSU, params);
	}
}
