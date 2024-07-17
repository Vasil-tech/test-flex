package com.flex.neoflex.services;

import com.flex.neoflex.models.ProfileRequest;
import com.flex.neoflex.models.User;
import com.flex.neoflex.repositories.UserRepository;
import io.micrometer.common.util.StringUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;
import static org.thymeleaf.util.StringUtils.isEmpty;

@Primary
@Service
public class UserServiceImpl implements UserService {

	private static final String SQL_INSERT_USER =
			"insert into usr (bank_id, lastname, name, patronymic, birth, passport, city, phone_number, email, address_reg, address_fact) values (:bank_id, :lastname, :name, :patronymic, :birth, :passport, :city, :phone_number, :email, :address_reg, :address_fact)";

//	private static final String SQL_GET_PROFILE_BY_NAME =
//			"select name, lastname, patronymic, email from usr where name = :name";

	private UserRepository userRepository;
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

//	final Map<Function<ProfileRequest, String>, Function<String, Iterable<User>>> map = new HashMap<>();
//	 {
//		map.put(ProfileRequest::name, userRepository::findByName);
//		map.put(ProfileRequest::lastname, userRepository::findByLastname);
//		map.put(ProfileRequest::patronymic, userRepository::findByPatronymic);
//		map.put(ProfileRequest::email, userRepository::findByEmail);
//	}
//
//	@Override
//	public Iterable<User> getUser(ProfileRequest request) {
//		return map.entrySet().stream()
//				.filter(e -> !!StringUtils.isEmpty(e.getKey().apply(request)))
//				.findFirst() // Optional<Map.Entry<F1, F2>>
//				.map(e -> e.getValue().apply(String.valueOf(request)))
//				.orElseGet(Collections::emptyList);
//	}
	@Override
	public Iterable<User> getUser(ProfileRequest request) {
		if (!StringUtils.isEmpty(request.name())) {
			return userRepository.findByName(request.name());
		} else if (!StringUtils.isEmpty(request.lastname())) {
			return userRepository.findByLastname(request.lastname());
		} else if (!StringUtils.isEmpty(request.patronymic())) {
			return userRepository.findByPatronymic(request.patronymic());
		} else if (!StringUtils.isEmpty(request.email())) {
			return userRepository.findByEmail(request.email());
		}
		else{
			return null;
		}
//		Stream.ofNullable(request.name())
//				.map(userRepository::findByName);
//		Stream.ofNullable(request.lastname())
//				.map(userRepository::findByLastname);
//		Stream.ofNullable(request.patronymic())
//				.map(userRepository::findByPatronymic);
//		Stream.ofNullable(request.email())
//				.map(userRepository::findByEmail);
//
//
//		List<String> list = new ArrayList<String>();
//		list.add(request.name());
//		list.add(request.lastname());
//		list.add(request.patronymic());
//		list.add(request.email());
//
//		Stream stream = list.stream();
//		list.stream().filter(name -> name.!StringUtils.isEmpty(request.name()).forEach(userRepository.findByName(request.name());
//		list.stream().filter(x-> x.toString().length() == 3).forEach(System.out::println);
//		list.stream().filter(x-> x.toString().length() == 3).forEach(System.out::println);
//		list.stream().filter(x-> x.toString().length() == 3).forEach(System.out::println);
//		return null;
	}

	@Override
	public Iterable<User> getUserById(int id) {
		return userRepository.findUserById(id);
	}
}