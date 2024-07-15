package com.flex.neoflex.controllers;

import com.flex.neoflex.models.ProfileRequest;
import com.flex.neoflex.models.User;
import com.flex.neoflex.repositories.UserRepository;
import com.flex.neoflex.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class AdminController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserServiceImpl userService;

	@GetMapping(value = "/{id:\\d+}")
	public Iterable<User> getUser(@PathVariable int id) {
		return userRepository.getUserById(id);
	}

	@PostMapping
	public Iterable<User> getUserBy(@RequestBody ProfileRequest request)  {
		return userService.getUser(
				request.name(),
				request.lastname(),
				request.patronymic(),
				request.email());
	}
}
