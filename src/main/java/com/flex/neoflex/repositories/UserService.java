package com.flex.neoflex.repositories;

import com.flex.neoflex.models.User;

import java.util.Optional;

public interface UserService {
	void createProfile(Integer bank_id, String lastname, String name, String patronymic,
					   Integer birth, String passport, String city, String phone_number, String email,
					   String address_reg, String address_fact);

	Optional<User> getUser(String name);

	Optional<User> getProfile(int personId);
}