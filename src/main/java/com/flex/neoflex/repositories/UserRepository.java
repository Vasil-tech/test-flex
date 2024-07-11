package com.flex.neoflex.repositories;

import com.flex.neoflex.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>
//		extends JpaRepository<User, Long>
	{
	Optional<User> getUserById(int id);
	List<User> findByName (String name);
	List<User> findByLastname (String lastname);
	List<User> findByPatronymic (String patronymic);
	List<User> findByEmail (String email);
}
