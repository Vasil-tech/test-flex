package com.flex.neoflex.services;

import com.flex.neoflex.models.ProfileRequest;
import com.flex.neoflex.models.User;
import com.flex.neoflex.repositories.UserRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import static org.thymeleaf.util.StringUtils.isEmpty;

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
	public void createProfile(ProfileRequest request) {
		var params = new MapSqlParameterSource();
		params.addValue("bank_id", request.bank_id());
		params.addValue("lastname", request.lastname());
		params.addValue("name", request.name());
		params.addValue("patronymic", request.patronymic());
		params.addValue("birth", request.birth());
		params.addValue("passport", request.passport());
		params.addValue("city", request.city());
		params.addValue("phone_number", request.phone_number());
		params.addValue("email", request.email());
		params.addValue("address_reg", request.address_reg());
		params.addValue("address_fact", request.address_fact());
		jdbcTemplate.update(SQL_INSERT_USER, params);
	}

	@Override
	public Iterable<User> getUser(ProfileRequest request) {
		switch (isEmpty()){
			case (request.name()):
				return userRepository.findByName(name);
		}
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

	@Override
	public Iterable<User> getUserById(int id) {
		return userRepository.findUserById(id);
	}
}