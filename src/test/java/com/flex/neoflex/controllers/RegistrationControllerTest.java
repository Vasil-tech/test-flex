package com.flex.neoflex.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flex.neoflex.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTest {
	@MockBean
	private UserRepository userRepository;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private RegistrationController registrationController;

	@Test
	void getRegrTest() throws Exception {
		mockMvc.perform(get("/register"))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	public void addMessageToListTest() throws Exception {
		MockHttpServletRequestBuilder multipart = multipart("/register")
				.content("""
					{
						"name": "test",
						"bank_id": "test",
						"lastname": "test",
						"patronymic": "test",
						"birth": "test",
						"passport": "test",
						"city": "test",
						"phone_number": "test",
						"email": "test",
						"address_reg": "test",
						"address_fact": "test"                
					}
            	""");

		mockMvc.perform(post("/register"))
				.andDo(print())
				.andExpect(status().isOk());
	}
}
