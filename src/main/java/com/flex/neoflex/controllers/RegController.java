package com.flex.neoflex.controllers;

import com.flex.neoflex.models.ProfileRequest;
import com.flex.neoflex.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/reg")
public class RegController {
	@Autowired
	private UserServiceImpl userService;

	@PostMapping
	public String createProfile(@RequestBody ProfileRequest request) {
		try {
			userService.createProfile(
					request.bank_id(),
					request.lastname(),
					request.name(),
					request.patronymic(),
					request.birth(),
					request.passport(),
					request.city(),
					request.phone_number(),
					request.email(),
					request.address_reg(),
					request.address_fact()
			);
			return "Зареган";
		}
		catch(Exception e){
			return "Не зареган: " + e.getMessage();
		}
	}
}