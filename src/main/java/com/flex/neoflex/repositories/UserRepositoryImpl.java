//package com.flex.neoflex.repositories;
//
//import com.flex.neoflex.models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public class UserRepositoryImpl {
//	@Autowired
//	private UserRepository userRepository;
//
//	private static final String SQL_GET_PROFILE_BY_ID =
//			"select id, first_name, last_name, age from profile where id = :id";
//
////	private final UserMapper profileMapper;
//	private final NamedParameterJdbcTemplate jdbcTemplate;
//
//	public UserRepositoryImpl() {
//	}
//
////	public ProfileRepositoryImpl(
////			ProfileMapper profileMapper,
////			NamedParameterJdbcTemplate jdbcTemplate
////	) {
////		this.profileMapper = profileMapper;
////		this.jdbcTemplate = jdbcTemplate;
////	}
//
//	@Override
//	public Optional<User> getProfileById(int id) {
//		var params = new MapSqlParameterSource();
//		params.addValue("id", id);
//		return jdbcTemplate.query(
//						SQL_GET_PROFILE_BY_ID,
//						params,
//						profileMapper
//				).stream()
//				.findFirst();
//	}
//}