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
				.name("United States of America")
				.capital("Washington, D.C.")
				.region("Americas")
				.subregion("Northern America")
				.build();
		
		Country c2 = Country.builder()
				.cioc("PAN")
				.name("Panama")
				.capital("Panama City")
				.region("Americas")
				.subregion("Central America")
				.build();
		
		Country c3 = Country.builder()
				.cioc("ASA")
				.name("American Samoa")
				.capital("Pago Pago")
				.region("Oceania")
				.subregion("Polynesia")
				.build();
		
		Country[] mockTests = { c1, c2, c3 };
		
		ResponseEntity<Country[]> mockResults = new ResponseEntity<Country[]>(mockTests, HttpStatus.OK);
		
		// TODO Review mock of RestTemplate to fix null pointer exception
		Mockito.when(restTemplate.getForEntity(anyString(), Country[].class)).thenReturn(mockResults);

		List<Country> countries = countryService.getCountries();

		assertEquals(countries.get(0).getName(), "American Samoa");

	}

}
