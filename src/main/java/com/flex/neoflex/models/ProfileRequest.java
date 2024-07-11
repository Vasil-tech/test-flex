package com.flex.neoflex.models;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.web.bind.annotation.RequestParam;

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