package com.flex.neoflex.repositories;

import com.flex.neoflex.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByName (String name);
	List<User> findByLastname (String lastname);
	List<User> findByPatronymic (String patronymic);
	List<User> findByEmail (String email);
}
