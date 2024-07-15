package com.flex.neoflex.repositories;

import com.flex.neoflex.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> 	{
	Iterable<User> getUserById(int id);
	Iterable<User> findByName (String name);
	Iterable<User> findByLastname (String lastname);
	Iterable<User> findByPatronymic (String patronymic);
	Iterable<User> findByEmail (String email);
}
