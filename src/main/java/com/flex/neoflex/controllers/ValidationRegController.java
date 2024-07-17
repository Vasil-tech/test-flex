package com.flex.neoflex.controllers;

import com.flex.neoflex.models.ProfileRequest;
import com.flex.neoflex.services.ValidationRegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class ValidationRegController {
	@Autowired
	private ValidationRegService userService;

	@PostMapping
	@RequestMapping(value = "/mail")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProfileEmail(@RequestBody ProfileRequest request) {
		userService.createProfileEmail(request.name(), request.email());
	}

	@PostMapping
	@RequestMapping(value = "/mobile")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProfileMobile(@RequestBody ProfileRequest request) {
		userService.createProfileMobile(request.phone_number());
	}

	@PostMapping
	@RequestMapping(value = "/bank")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProfileBank(@RequestBody ProfileRequest request) {
		userService.createProfileBank(
				request.bank_id(),
				request.lastname(),
				request.name(),
				request.patronymic(),
				request.birth(),
				request.passport()
		);
	}

	@PostMapping
	@RequestMapping(value = "/gosu")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProfileGosu(@RequestBody ProfileRequest request) {
		userService.createProfileGosu(
				request.bank_id(),
				request.lastname(),
				request.name(),
				request.patronymic(),
				request.birth(),
				request.passport(),
				request.city(),
				request.phone_number(),
				request.address_reg()
		);
	}
}