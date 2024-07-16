package com.flex.neoflex.controllers;

import com.flex.neoflex.services.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
	void findOneShouldReturnValidBook() throws Exception {
		Mockito.when(this.userService.getUserById(1)).thenReturn(null);

		mvc.perform(get("/user/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.data.items[0].id").value(1))
				.andExpect(jsonPath("$.bank_id").value(123))
				.andExpect(jsonPath("$.lastname").value("Cock"))
				.andExpect(jsonPath("$.name").value("Fat"))
				.andExpect(jsonPath("$.patronymic").value("Boobs"))
				.andExpect(jsonPath("$.birth").value(12042002))
				.andExpect(jsonPath("$.passport").value("189273987213"))
				.andExpect(jsonPath("$.city").value("cum"))
				.andExpect(jsonPath("$.phone_number").value("129387192873"))
				.andExpect(jsonPath("$.email").value("xamistic02@gmail.com"))
				.andExpect(jsonPath("$.address_reg").value("Златоустинская"))
				.andExpect(jsonPath("$.address_fact").value("Fatcocockovskaya"));
	}
}
