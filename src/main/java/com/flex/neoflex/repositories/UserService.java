package com.flex.neoflex.repositories;

import com.flex.neoflex.models.User;

public interface UserService {
	void createProfile(Integer bank_id, String lastname, String name, String patronymic,
					   Integer birth, String passport, String city, String phone_number, String email,
					   String address_reg, String address_fact);

	Iterable<User> getUser(String name, String lastname, String patronymic, String email);

	Iterable<User> getUserById(int id);
}