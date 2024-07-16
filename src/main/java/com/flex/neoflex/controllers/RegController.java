package com.flex.neoflex.controllers;

import com.flex.neoflex.models.ProfileRequest;
import com.flex.neoflex.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
@RequestMapping(value = "/reg")
public class RegController {
	@Autowired
	private UserServiceImpl userService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createProfile(@RequestBody ProfileRequest request) {
		userService.createProfile(request);
	}
}