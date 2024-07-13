package com.flex.neoflex.controllers;

import com.flex.neoflex.models.User;
import com.flex.neoflex.repositories.UserRepository;
import com.flex.neoflex.services.ProfileRepositoryImpl;
import com.flex.neoflex.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class AdminController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProfileRepositoryImpl userService;

//	@GetMapping(value = "/{name}")
//	public Optional<User> getUser(@PathVariable String name) {
//		return userRepository.findByName(name);
//	}

	@GetMapping(value = "/{name}")
	public Optional<User> getUserBy(@PathVariable String name)  {
		return userService.getUser(name);
	}
//	@Autowired
//	private UserRepository userRepository;
//
//	@GetMapping
//	public String showRegPage(Model model) {
//		return "admin";
//	}
//
//	@PostMapping
//	public String filter(@RequestParam String name, @RequestParam String lastname,
//						 @RequestParam String patronymic, @RequestParam String email, Model model) {
//		Iterable<User> name_ = userRepository.findByName(name);
//		Iterable<User> lastname_ = userRepository.findByLastname(lastname);
//		Iterable<User> patronymic_ = userRepository.findByPatronymic(patronymic);
//		Iterable<User> email_ = userRepository.findByEmail(email);
//
//		if (!name.equals("")) {
//			model.addAttribute("user", name_);
//		} else if (!lastname.equals("")) {
//			model.addAttribute("user", lastname_);
//		} else if (!patronymic.equals("")) {
//			model.addAttribute("user", patronymic_);
//		} else if (!email.equals("")) {
//			model.addAttribute("user", email_);
//		}
//
//		return "admin";
//	}
}
