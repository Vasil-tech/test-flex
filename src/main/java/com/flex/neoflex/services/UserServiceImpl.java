package com.flex.neoflex.services;

import com.flex.neoflex.models.User;
import com.flex.neoflex.repositories.UserRepository;
import com.flex.neoflex.repositories.UserService;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Primary
@Service
public class UserServiceImpl implements UserService {

	private static final String SQL_INSERT_USER =
			"insert into usr (bank_id, lastname, name, patronymic, birth, passport, city, phone_number, email, address_reg, address_fact) values (:bank_id, :lastname, :name, :patronymic, :birth, :passport, :city, :phone_number, :email, :address_reg, :address_fact)";

	private static final String SQL_GET_PROFILE_BY_NAME =
			"select name, lastname, patronymic, email from usr where name = :name";

	private final UserRepository userRepository;
	private final NamedParameterJdbcTemplate jdbcTemplate;
	private final ProfileMapper profileMapper;

	public UserServiceImpl(UserRepository userRepository, NamedParameterJdbcTemplate jdbcTemplate, ProfileMapper profileMapper) {
		this.userRepository = userRepository;
		this.jdbcTemplate = jdbcTemplate;
		this.profileMapper = profileMapper;
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
	public Optional<User> getUser(String name, String lastname, String patronymic, String email) {
		var params = new MapSqlParameterSource();
		params.addValue("name", name);
		params.addValue("lastname", lastname);
		params.addValue("patronymic", patronymic);
		params.addValue("email", email);
//		var Johnny = jdbcTemplate.query(SQL_GET_PROFILE_BY_NAME, params, profileMapper)
//				.stream()
//				.findFirst();
		if (!name.equals("")) {
			return userRepository.findByName(name);
		} else if (!lastname.equals("")) {
			return userRepository.findByLastname(lastname);
		} else if (!patronymic.equals("")) {
			return userRepository.findByPatronymic(patronymic);
		} else if (!email.equals("")) {
			return userRepository.findByEmail(email);
		}
		else{
			return null;
		}
	}
//	@Override
//	public Optional<User> getUser(String name, String lastname, String patronymic, String email) {
////		Iterable<User> name_ = userRepository.findByName(name);
////		Iterable<User> lastname_ = userRepository.findByLastname(lastname);
////		Iterable<User> patronymic_ = userRepository.findByPatronymic(patronymic);
////		Iterable<User> email_ = userRepository.findByEmail(email);
//
//		if (!name.equals("")) {
//			return userRepository.findByName(name);
//		} else if (!lastname.equals("")) {
//			return userRepository.findByLastname(lastname);
//		} else if (!patronymic.equals("")) {
//			return userRepository.findByPatronymic(patronymic);
//		} else if (!email.equals("")) {
//			return userRepository.findByEmail(email);
//		}
//		else{
//			return null;
//		}
//	}
}