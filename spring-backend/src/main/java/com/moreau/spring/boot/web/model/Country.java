package com.moreau.spring.boot.web.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country implements Serializable {
    
	private static final long serialVersionUID = 8812383209004946338L;


	@JsonProperty("cioc")
	private String cioc;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("capital")
	private String capital;
	
	@JsonProperty("region")
	private String region;
	
	@JsonProperty("subregion")
	private String subregion;
	
}
