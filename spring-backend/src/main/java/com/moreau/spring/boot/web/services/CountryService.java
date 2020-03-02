package com.moreau.spring.boot.web.services;

import java.util.List;

import com.moreau.spring.boot.web.model.Country;

public interface CountryService {

	List<Country> getCountries();
}
