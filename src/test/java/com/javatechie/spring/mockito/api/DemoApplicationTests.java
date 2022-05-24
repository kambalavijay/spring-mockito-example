package com.javatechie.spring.mockito.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.spring.mockito.api.country.CountryVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringMockitoApplication.class, H2JpaConfig.class})
public class DemoApplicationTests {

	private MockMvc mockMvc;
	@Autowired
	private WebApplicationContext webApplicationContext;
	@Autowired
	private ObjectMapper objectMapper;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

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

}
