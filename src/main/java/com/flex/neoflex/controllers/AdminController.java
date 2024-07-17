package com.flex.neoflex.controllers;

import com.flex.neoflex.models.ProfileRequest;
import com.flex.neoflex.models.User;
import com.flex.neoflex.services.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class AdminController {
	private final UserServiceImpl userService;

	public AdminController(UserServiceImpl userService) {
		this.userService = userService;
	}

	@GetMapping(value = "/{id:\\d+}")
	public Iterable<User> getUser(@PathVariable int id) {
		return userService.getUserById(id);
	}

	@PostMapping
	public Iterable<User> getUserBy(@RequestBody ProfileRequest request)  {
		return userService.getUser(request);
	}
}
