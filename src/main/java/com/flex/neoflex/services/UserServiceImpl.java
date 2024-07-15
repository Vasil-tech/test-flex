package com.flex.neoflex.services;

import com.flex.neoflex.models.User;
import com.flex.neoflex.repositories.UserRepository;
import com.flex.neoflex.repositories.UserService;
import io.micrometer.common.util.StringUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Primary
@Service
public class UserServiceImpl implements UserService {

	private static final String SQL_INSERT_USER =
			"insert into usr (bank_id, lastname, name, patronymic, birth, passport, city, phone_number, email, address_reg, address_fact) values (:bank_id, :lastname, :name, :patronymic, :birth, :passport, :city, :phone_number, :email, :address_reg, :address_fact)";

//	private static final String SQL_GET_PROFILE_BY_NAME =
//			"select name, lastname, patronymic, email from usr where name = :name";

	private final UserRepository userRepository;
	private final NamedParameterJdbcTemplate jdbcTemplate;

	public UserServiceImpl(UserRepository userRepository, NamedParameterJdbcTemplate jdbcTemplate) {
		this.userRepository = userRepository;
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void createProfile(Integer bank_id, String lastname, String name, String patronymic, Integer birth,
							  String passport, String city, String phone_number, String email, String address_reg, String address_fact) {
		var params = new MapSqlParameterSource();
		params.addValue("bank_id", bank_id);
		params.addValue("lastname", lastname);
		params.addValue("name", name);
		params.addValue("patronymic", patronymic);
		params.addValue("birth", birth);
		params.addValue("passport", passport);
		params.addValue("city", city);
		params.addValue("phone_number", phone_number);
		params.addValue("email", email);
		params.addValue("address_reg", address_reg);
		params.addValue("address_fact", address_fact);
		jdbcTemplate.update(SQL_INSERT_USER, params);
	}
	@Override
	public Iterable<User> getUser(String name, String lastname, String patronymic, String email) {
		if (!StringUtils.isEmpty(name)) {
			return userRepository.findByName(name);
		} else if (!StringUtils.isEmpty(lastname)) {
			return userRepository.findByLastname(lastname);
		} else if (!StringUtils.isEmpty(patronymic)) {
			return userRepository.findByPatronymic(patronymic);
		} else if (!StringUtils.isEmpty(email)) {
			return userRepository.findByEmail(email);
		}
		else{
			return null;
		}
	}
}