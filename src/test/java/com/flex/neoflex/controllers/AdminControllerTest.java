package com.flex.neoflex.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flex.neoflex.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdminController.class)
public class AdminControllerTest {
	@MockBean
	private UserRepository userRepository;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private AdminController adminController;

	@Test
	void getUserTest() throws Exception {
		mockMvc.perform(get("/admin"))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void filterUserTest() throws Exception {
		mockMvc.perform(post("/admin")
						.param("name", "test")
						.param("lastname", "test")
						.param("patronymic", "test")
						.param("email", "test@test"))
				.andDo(print())
				.andExpect(status().isOk());
	}
}
