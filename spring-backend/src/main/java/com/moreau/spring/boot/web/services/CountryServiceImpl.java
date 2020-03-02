package com.moreau.spring.boot.web.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.moreau.spring.boot.web.model.Country;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Country> getCountries() {

		// Make API call and convert into list of countries
		ResponseEntity<Country[]> response = restTemplate.getForEntity("https://restcountries.eu/rest/v2/all", Country[].class);
		List<Country> countries = new ArrayList<Country>(Arrays.asList(response.getBody()));

		// Filter out null CiocIds and ensure Name is sorted alphabetical
		countries = countries.stream().filter(country -> country.getCioc() != null && !country.getCioc().isEmpty())
				.sorted(Comparator.comparing(Country::getName)).collect(Collectors.toList());

		
		return countries;
	}

}
