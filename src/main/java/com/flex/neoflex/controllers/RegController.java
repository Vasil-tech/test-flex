package com.flex.neoflex.controllers;

import com.flex.neoflex.models.ProfileRequest;
import com.flex.neoflex.models.User;
import com.flex.neoflex.repositories.ProfileService;
import com.flex.neoflex.repositories.UserRepository;
import com.flex.neoflex.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/profiles")
public class RegController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserServiceImpl userService;

	@GetMapping(value = "/{personId:\\d+}")
	public Optional<User> getProfile(@PathVariable int personId) {
		return userRepository.getUserById(personId);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createProfile(@RequestBody ProfileRequest request) {
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
	}
}