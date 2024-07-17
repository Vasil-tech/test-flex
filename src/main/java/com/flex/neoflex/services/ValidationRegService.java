package com.flex.neoflex.services;

public interface ValidationRegService {
	void createProfileEmail(String name, String email);
	void createProfileMobile(String phone_number);
	void createProfileBank(Integer bank_id, String name, String lastname, String patronymic, Integer birth, String passport);
	void createProfileGosu(Integer bank_id, String name, String lastname, String patronymic, Integer birth, String passport, String city, String phone_number, String address_reg);

}
