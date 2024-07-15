package com.flex.neoflex.repositories;

import com.flex.neoflex.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> 	{
	Optional<User> getUserById(int id);
	Optional<User> findByName (String name);
	Optional<User> findByLastname (String lastname);
	Optional<User> findByPatronymic (String patronymic);
	Optional<User> findByEmail (String email);
}
