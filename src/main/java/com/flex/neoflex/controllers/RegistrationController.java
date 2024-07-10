package com.flex.neoflex.controllers;

import com.flex.neoflex.models.User;
import com.flex.neoflex.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public String showRegPage() {
		return "register";
	}

	@PostMapping
	public String registerUser(@RequestParam(required = true, defaultValue = "") String name,
							   @RequestParam (required = true, defaultValue = "") Integer bank_id,
							   @RequestParam (required = true, defaultValue = "") String lastname,
							   @RequestParam (required = true, defaultValue = "") String patronymic,
							   @RequestParam (required = true, defaultValue = "") Integer birth,
							   @RequestParam (required = true, defaultValue = "") String passport,
							   @RequestParam (required = true, defaultValue = "") String city,
							   @RequestParam (required = true, defaultValue = "") String phone_number,
							   @RequestParam (required = true, defaultValue = "") String email,
							   @RequestParam (required = true, defaultValue = "") String address_reg,
							   @RequestParam (required = true, defaultValue = "") String address_fact) {
		if(!(name.equals("") & lastname.equals("")
				& patronymic.equals("") & phone_number.equals("")
				& email.equals(""))) {
					User user = new User();
					user.setName(name);
					user.setBank_id(bank_id);
					user.setLastname(lastname);
					user.setPatronymic(patronymic);
					user.setBirth(birth);
					user.setPassport(passport);
					user.setCity(city);
					user.setPhone_number(phone_number);
					user.setEmail(email);
					user.setAddress_reg(address_reg);
					user.setAddress_fact(address_fact);
					userRepository.save(user);
				}
		return "register";
	}

}
