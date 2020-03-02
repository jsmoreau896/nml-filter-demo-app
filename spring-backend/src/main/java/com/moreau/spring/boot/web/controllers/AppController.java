package com.moreau.spring.boot.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.moreau.spring.boot.web.services.CountryServiceImpl;

@Controller
public class AppController {

	@Autowired
	CountryServiceImpl countryService;
	
	@RequestMapping("/home")
    public String showHome(ModelMap model){
		model.addAttribute("countries", countryService.getCountries());
        return "home";
    }
}
