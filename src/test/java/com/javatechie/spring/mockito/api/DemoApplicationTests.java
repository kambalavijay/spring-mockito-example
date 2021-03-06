package com.javatechie.spring.mockito.api;

import com.javatechie.spring.mockito.api.country.model.VO.CountryVO;
import org.junit.Test;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class DemoApplicationTests extends BaseTest{

	@Test
	public void testCreateCountry() throws Exception {
		CountryVO countryVO = CountryVO.builder().name("India").code("IN").continent("Asia").
				population(13000000000L).capital("Delhi").build();
		String countryJson = objectMapper.writeValueAsString(countryVO);
		mockMvc.perform(post("/api/v1/country").content(countryJson)
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
		.andExpect(status().is2xxSuccessful())
		.andExpect(jsonPath("$.name").value("India"))
		.andExpect(jsonPath("$.continent").value("Asia"))
		.andExpect(jsonPath("$.capital").value("Delhi"))
		.andExpect(jsonPath("$.code").value("IN"))
		.andExpect(jsonPath("$.population").value(13000000000L));
	}

	@Test
	public void testGetCountryById() throws Exception {
		mockMvc.perform(get("/api/v1/country/1")).andExpect(status().isOk())
				.andExpect(status().is2xxSuccessful())
				.andExpect(jsonPath("$.name").value("India"))
				.andExpect(jsonPath("$.continent").value("Asia"))
				.andExpect(jsonPath("$.capital").value("Delhi"))
				.andExpect(jsonPath("$.code").value("IN"))
				.andExpect(jsonPath("$.population").value(13000000000L));
	}
}
