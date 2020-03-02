package com.moreau.spring.boot.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.moreau.spring.boot.web.model.Country;
import com.moreau.spring.boot.web.services.CountryServiceImpl;

@RestController
//@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api")
public class ApiController {

	@Autowired
	CountryServiceImpl countryService;
	
	@GetMapping("/countries")
	public List<Country> getCountries(){
		return countryService.getCountries();
	}
	
}
