package com.moreau.spring.boot.web.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.ArgumentMatchers.anyString;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.moreau.spring.boot.web.model.Country;

@RunWith(MockitoJUnitRunner.class)
class CountryServiceImplTest {

	@Mock(answer = Answers.RETURNS_DEEP_STUBS)
	private RestTemplate restTemplate;

	@InjectMocks
	private CountryServiceImpl countryService = new CountryServiceImpl();

	
	@Ignore
	void testGetCountryListByApiCall_shouldReturnFilteredCountryListAlphabetical() {

		// Mock the test array
		Country c1 = Country.builder()
				.cioc("USA")
				.name("United States")
				.capital("Washington")
				.region("America")
				.subregion("North America")
				.build();
		
		Country c2 = Country.builder()
				.cioc("BOL")
				.name("Boliva")
				.capital("Washington")
				.region("America")
				.subregion("North America")
				.build();
		
		Country c3 = Country.builder()
				.cioc("AFG")
				.name("Afghanistan")
				.capital("Kabul")
				.region("Middle East")
				.subregion("North America")
				.build();
		
		Country[] mockTests = { c1, c2, c3 };
		
		ResponseEntity<Country[]> mockResults = new ResponseEntity<Country[]>(mockTests, HttpStatus.OK);
		Mockito.when(restTemplate.getForEntity(anyString(), Country[].class)).thenReturn(mockResults);


		List<Country> countries = countryService.getCountries();

		assertEquals(countries.get(0).getName(), "Afghanistan");

	}

}
