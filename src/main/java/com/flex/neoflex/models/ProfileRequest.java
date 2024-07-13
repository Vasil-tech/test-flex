package com.flex.neoflex.models;

public record ProfileRequest(
		String name,
		Integer bank_id,
		String lastname,
		String patronymic,
		Integer birth,
		String passport,
		String city,
		String phone_number,
		String email,
		String address_reg,
		String address_fact
) {
}