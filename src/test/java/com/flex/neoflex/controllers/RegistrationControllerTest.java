package com.flex.neoflex.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flex.neoflex.repositories.UserRepository;
import com.flex.neoflex.services.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(RegController.class)
public class RegistrationControllerTest {
	@MockBean
	private UserRepository userRepository;

	@MockBean
	private UserServiceImpl userService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private RegController registrationController;

	@Test
	public void regTest() throws Exception {
		URI uri = new URI("/reg");
		String json = "{\"bank_id\":123, \"lastname\":\"test\", \"name\":\"test\", \"patronymic\":\"test\", " +
				"\"birth\":12365, \"passport\": \"189273987213\", \"city\": \"city\", \"phone_number\": \"987123\", " +
				"\"email\": \"test@test\",  \"address_reg\": \"test\", \"address_fact\": \"test\"}";

		mockMvc.perform(MockMvcRequestBuilders
						.post(uri)
						.content(json)
						.contentType(org.springframework.http.MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
}
