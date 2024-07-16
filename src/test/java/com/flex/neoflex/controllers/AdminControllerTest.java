package com.flex.neoflex.controllers;

import com.flex.neoflex.services.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.net.URI;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AdminController.class)
public class AdminControllerTest {
	@MockBean
	private UserServiceImpl userService;

	@Autowired
	private MockMvc mvc;

	@Test
	public void testIndex() throws Exception {
		var result = mvc.perform(get("/user/1"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		var body = result.getResponse().getContentAsString();
		assertThatJson(body).isArray();
	}

	@Test
	public void adminTest() throws Exception {
		URI uri = new URI("/user");
		String json = "{\"name\":\"test\", \"lastname\":\"test\", \"patronymic\":\"test\", \"email\": \"test@test\"}";

		mvc.perform(MockMvcRequestBuilders
						.post(uri)
						.content(json)
						.contentType(org.springframework.http.MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(MockMvcResultMatchers.status().is(200));
	}
}
